import com.sun.org.apache.bcel.internal.generic.LLOAD;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class DbPoolImpl implements DbPool {
    /**
     * �������ӳ�
     */
    private LinkedBlockingQueue<Connection> idleConnectPool;

    /**
     * ��Ծ���ӳ�
     */
    private LinkedBlockingQueue<Connection> busyConnectPool;

    /**
     * ��ǰ���ڱ�ʹ�õ�������
     */
    private AtomicInteger activeSize = new AtomicInteger(0);

    /**
     * ���������
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
        // ��idle ����ȡ��һ������
        Connection connection = idleConnectPool.poll();
        if(connection != null){
            //  ��������ӣ������busy ����
            busyConnectPool.offer(connection);
            System.out.println("��ȡ������");
            return connection;
        }
        //idle ����û������
        // ���idele ��������δ�� maxSize �����½�һ������
        if(activeSize.get() < maxSize ){
            // ͨ�� activeSize.incrementAndGet() <= maxSize ����ж�
            // ��� if(activeSize.get() < maxSize) ���ڵ��̰߳�ȫ����
            if(activeSize.incrementAndGet() <= maxSize ){
                connection = DbUtil.createConnection();  //����������
                busyConnectPool.offer(connection);
                return connection;
            }
        }
        try{
            System.out.println("�Ŷӵȴ�����");
            connection = idleConnectPool.poll(10000, TimeUnit.MILLISECONDS);// ������ȡ���ӣ����10���������������ͷţ�
            if(connection == null){
                System.out.println("�ȴ���ʱ");
                throw new RuntimeException("�ȴ����ӳ�ʱ");
            }
            System.out.println("�ȴ�����һ������");
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
     * ��ʱ�����ӽ��н������
     * ע�⣺ֻ�ܶ�idle���ӳ��е����ӽ��н�����飬
     * �����Զ�busyConnectPool���ӳ��е����ӽ��н�����飬��Ϊ�����ڱ��ͻ���ʹ��;
     */
    //@Scheduled(fixedRate = 60 * 1000)
    public void check() {
        for (int i = 0; i < activeSize.get(); i++) {
            Connection connection = idleConnectPool.poll();
            try {
                boolean valid = connection.isValid(2000);
                if (!valid) {
                    // ������Ӳ����ã��򴴽�һ���µ�����
                    connection =DbUtil.createConnection();
                }
                idleConnectPool.offer(connection);// �Ž�һ�����õ�����
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void destroy() {

    }
}
