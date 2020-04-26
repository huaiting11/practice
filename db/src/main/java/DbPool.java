import java.sql.Connection;

public interface DbPool {

    void init();

    /**
     * 获取一个连接
     *
     * @return
     */
    Connection getConnection();

    /**
     * 释放一个连接
     *
     * @param connection
     */
    void releaseConnection(Connection connection);

    /**
     * 销毁连接池
     */
    void destroy();
}
