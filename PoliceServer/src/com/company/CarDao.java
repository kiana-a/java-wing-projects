package com.company;

import java.sql.*;

/**
 * Created by kiana on 2/3/18.
 */
public class CarDao {

    public CarDao() {
        this.createTable();
    }


    private void createTable() {
        Connection connection = JdbcMysql.getConnection();
        Statement statement = null;

        String createTableSql = "CREATE TABLE Car(" +
                "chassisNum VARCHAR(20) NOT NULL ," +
                "model VARCHAR(20)," +
                "color VARCHAR(20)," +
                "PRIMARY KEY (chassisNum)" +
                ")";

        try {
            statement = connection.createStatement();
            statement.execute(createTableSql);

        } catch (SQLException e) {
//            e.printStackTrace();
            System.out.println("car table exists");

        }
        System.out.println("Car Dao Table is created ");
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(Car car) {
        Connection connection = JdbcMysql.getConnection();
        PreparedStatement statement = null;
        Savepoint savepoint = null;

        String insertInto = "INSERT INTO Car(chassisNum,model,color) VALUES (?,?,?)";
        try {
            statement = connection.prepareStatement(insertInto);
            statement.setString(1, car.getChassisNum());
            statement.setString(2, car.getModel());
            statement.setString(3, car.getColor().name());

            statement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("a car is created (without plaque & Owner) ");

        }
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public Car findCar(String chassisNum) {

        Connection connection = JdbcMysql.getConnection();
        PreparedStatement preparedStatement = null;
        Car car = null;
        String findCar = "SELECT * FROM Car WHERE chassisNum=?";
        try {
            preparedStatement = connection.prepareStatement(findCar);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            preparedStatement.setString(1, chassisNum);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                car = new Car(
                        resultSet.getString("chassisNum"),
                        resultSet.getString("model"),
                        Color.valueOf(resultSet.getString("color"))
                );
            }

        } catch (SQLException e) {
//            e.printStackTrace();
            System.out.println("found your car ");

        }
        try {
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return car;
    }





//    public boolean doesThisCarExist(String chassisNum) {
//        Connection connection = JdbcMysql.getConnection();
//        PreparedStatement preparedStatement = null;
//        Car car = null;
//        String findCar = "SELECT * FROM Car WHERE chassisNum=?";
//        try {
//            preparedStatement = connection.prepareStatement(findCar);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            try {
//                preparedStatement.setString(1, chassisNum);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//            ResultSet resultSet = null;
//            try {
//                resultSet = preparedStatement.executeQuery();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//            try {
//                if (resultSet.next()) {
//                    try {
//                        car = new Car(
//                                resultSet.getString("chassisNum"),
//                                resultSet.getString("model"),
//                                Color.valueOf(resultSet.getString("color"))
//                        );
//
//                    } catch (SQLException e) {
//                        e.printStackTrace();
//                    }
//                    return true;
//                }
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        } finally {
//            try {
//                preparedStatement.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            try {
//                connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }return false;
//
//    }


}
