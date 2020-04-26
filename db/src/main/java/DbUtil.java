import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtil {
    private static String driverClass = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/testdb";
    private static String username = "root";
    private static String password = "123456";
    /**
     * 创建数据库连接
     *
     */
    public static Connection createConnection(){
        Connection connection = null;
        try {
           Class.forName(driverClass);
           connection = DriverManager.getConnection(url,username,password);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    /**
     * 执行插入操作
     *
     * @param connection
     * @param insertSql
     * @throws SQLException
     */
    public static void executeInsert(Connection connection, String insertSql) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(insertSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
