import com.sun.org.apache.bcel.internal.generic.LLOAD;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class DbPoolImpl implements DbPool {
    /**
     * 空闲连接池
     */
    private LinkedBlockingQueue<Connection> idleConnectPool;

    /**
     * 活跃连接池
     */
    private LinkedBlockingQueue<Connection> busyConnectPool;

    /**
     * 当前正在被使用的连接数
     */
    private AtomicInteger activeSize = new AtomicInteger(0);

    /**
     * 最大连接数
     */
    private final int maxSize;

    public DbPoolImpl(int maxSize) {
        this.maxSize = maxSize;
        init();// init pool
    }


    public void init() {
        idleConnectPool = new LinkedBlockingQueue<Connection>();
        busyConnectPool = new LinkedBlockingQueue<Connection>();
    }

    public Connection getConnection() {
        // 从idle 池中取出一个连接
        Connection connection = idleConnectPool.poll();
        if(connection != null){
            //  如果有连接，则放入busy 池中
            busyConnectPool.offer(connection);
            System.out.println("获取到连接");
            return connection;
        }
        //idle 池中没有链接
        // 如果idele 池中链接未满 maxSize ，就新建一个连接
        if(activeSize.get() < maxSize ){
            // 通过 activeSize.incrementAndGet() <= maxSize 这个判断
            // 解决 if(activeSize.get() < maxSize) 存在的线程安全问题
            if(activeSize.incrementAndGet() <= maxSize ){
                connection = DbUtil.createConnection();  //创建新连接
                busyConnectPool.offer(connection);
                return connection;
            }
        }
        try{
            System.out.println("排队等待链接");
            connection = idleConnectPool.poll(10000, TimeUnit.MILLISECONDS);// 阻塞获取连接，如果10秒内有其他连接释放，
            if(connection == null){
                System.out.println("等待超时");
                throw new RuntimeException("等待连接超时");
            }
            System.out.println("等待到了一个连接");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void releaseConnection(Connection connection) {
        if(connection != null){
            busyConnectPool.remove(connection);
            idleConnectPool.offer(connection);
        }
    }
    /**
     * 定时对连接进行健康检查
     * 注意：只能对idle连接池中的连接进行健康检查，
     * 不可以对busyConnectPool连接池中的连接进行健康检查，因为它正在被客户端使用;
     */
    //@Scheduled(fixedRate = 60 * 1000)
    public void check() {
        for (int i = 0; i < activeSize.get(); i++) {
            Connection connection = idleConnectPool.poll();
            try {
                boolean valid = connection.isValid(2000);
                if (!valid) {
                    // 如果连接不可用，则创建一个新的连接
                    connection =DbUtil.createConnection();
                }
                idleConnectPool.offer(connection);// 放进一个可用的连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void destroy() {

    }
}
