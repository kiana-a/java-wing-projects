package run.wing.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by kiana on 12/26/17.
 */
public class JdbcMysql {
    private static final String userName = "kiana";
    private static final String password = "123456";
    private static final String connectionURL = "jdbc:mysql://localhost:3306/wing?useSSL=false";
    private static final String driverName = "com.mysql.jdbc.Driver";

    public static Connection getConnection(){
        Connection connection = null;

        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(connectionURL,userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
