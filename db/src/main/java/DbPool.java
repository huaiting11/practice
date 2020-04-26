import java.sql.Connection;

public interface DbPool {

    void init();

    /**
     * ��ȡһ������
     *
     * @return
     */
    Connection getConnection();

    /**
     * �ͷ�һ������
     *
     * @param connection
     */
    void releaseConnection(Connection connection);

    /**
     * �������ӳ�
     */
    void destroy();
}
