/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;*/

import java.sql.Connection;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;

/*@RestController
@RequestMapping("/test")*/
public class TestController {

    private static int executorThreadSize = 20;
    private static String insertSql = "INSERT INTO `user_tbl` (`name`) VALUES ('%s');";
    private CountDownLatch countDownLatch = new CountDownLatch(10);

    //@Autowired
    private DbPool dbPool;

   // @GetMapping("/pool")
    public String dbPoolTest() {
        System.out.println("请求线程:" + Thread.currentThread().getName());
        new Thread(new Runnable() {
            @Override
            public void run() {
                countDownLatch.countDown();
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 10; i++) {
                    Connection connection = dbPool.getConnection();// 从连接池获取连接
                    // 模拟插入数据
                    DbUtil.executeInsert(connection, String.format(insertSql, UUID.randomUUID().toString()));
                    dbPool.releaseConnection(connection);// 释放连接
                }
            }
        }).start();
        return "success";
    }
}