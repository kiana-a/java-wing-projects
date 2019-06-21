package run.wing.model.dao;

import run.wing.db.JdbcMysql;
import run.wing.model.to.Person;
import run.wing.model.to.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiana on 12/31/17.
 */
public class TaskDao {

    public TaskDao() {
        this.createTable();
    }
    //chera creayeTable ghermeze ?

    private void createTable() {
        Connection connection = JdbcMysql.getConnection();
        Statement statement = null;
        String createTable = "CREATE TABLE Task (" +
                "id INT NOT NULL AUTO_INCREMENT," +
                "startDate DATE, " +
                "endDate DATE, " +
                "point INT ," +
                "description VARCHAR(50)," +
                "person INT ," +
                "PRIMARY KEY (id)," +
                "FOREIGN KEY (person) REFERENCES Person(id))";
        try {
            statement = connection.createStatement();
            statement.execute(createTable);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
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
    }

    public void save(Task task) {
        Connection connection = JdbcMysql.getConnection();
        PreparedStatement preparedStatement = null;
        String insertInto = "INSERT INTO Task(startDate,endDate,point,description,person)VALUES (?,?,?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(insertInto);
            preparedStatement.setDate(1, new Date(System.currentTimeMillis()));
            preparedStatement.setDate(2, task.getEndDate());
            preparedStatement.setInt(3, task.getPoint());
            preparedStatement.setString(4, task.getDescription());
            preparedStatement.setInt(5, task.getPerson().getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                System.out.println("A Task is saved");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
//
//    public void update(Task task){
//        Connection connection = JdbcMysql.getConnection();
//        PreparedStatement preparedStatement = null;
//        String updateTask  = "UPDATE Task SET description=? WHERE id=?";
//        try {
//            preparedStatement.setString(1,task.getDescription());
//            preparedStatement.setInt(2,id); //ah.
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
//        try {
//            preparedStatement = connection.prepareStatement(updateTask);
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                preparedStatement.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            try {
//                connection.close();
//                System.out.println("Task is update");
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public void delete(int id){
//        Connection connection = JdbcMysql.getConnection();
//        PreparedStatement preparedStatement = null;
//        String deleteTaskRecord = "DELETE FROM Task WHERE id=?";
//        try {
//            preparedStatement = connection.prepareStatement(deleteTaskRecord);
//            preparedStatement.setInt(1, id);
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                preparedStatement.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            try {
//                connection.close();
//                System.out.println("Delete : Done ");
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }


    public List<Task> findByPersonId(int id) {
        Connection connection = JdbcMysql.getConnection();
        PreparedStatement preparedStatement = null;
        List<Task> tasks = new ArrayList<>();
        String findById = "SELECT Task.id, Task.endDate, Task.startDate, Task.description, Task.point FROM Task INNER JOIN Person ON Task.person = Person.id WHERE Task.person=?";
        try {
            preparedStatement = connection.prepareStatement(findById);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                tasks.add(new Task(
                        resultSet.getInt("id"),
                        resultSet.getDate("startDate"),
                        resultSet.getDate("endDate"),
                        resultSet.getInt("point"),
                        resultSet.getString("description")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                System.out.println("A Task is saved");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return tasks;
    }

    public List<Task> findAllTasks() {
        Connection connection = JdbcMysql.getConnection();
        PreparedStatement preparedStatement = null;
        List<Task> taskList = new ArrayList<>();

        String findAllTasks = "SELECT Task.id,Task.endDate,Task.startDate,Task.point,Task.description,Person.id,Person.name" +
                ",Person.lname,Person.age,Person.createdAt FROM Task LEFT JOIN Person ON Task.person = Person.id";
        try {
            preparedStatement = connection.prepareStatement(findAllTasks);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                taskList.add(new Task(
                        resultSet.getInt("id"),
                        resultSet.getDate("startDate"),
                        resultSet.getDate("endDate"),
                        resultSet.getInt("point"),
                        resultSet.getString("description"),
                        new Person(resultSet.getString("name"), resultSet.getString("lname"), resultSet.getInt("age"))
                ));
            }
        } catch (SQLException e)

        {
            e.printStackTrace();
        }finally {
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
        }
        return taskList;

    }


}
