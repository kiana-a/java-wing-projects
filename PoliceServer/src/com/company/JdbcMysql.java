package com.company;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by kiana on 2/3/18.
 */
public class JdbcMysql {
    private static final String userName = "kiana";
    private static final String password = "123456"; // dont change it
    private static final String connectiolURL = "jdbc:mysql://localhost:3306/wing?useSSL=false";
    private static final String driverName = "com.mysql.jdbc.Driver";

    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(connectiolURL,userName,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;


    }

}
