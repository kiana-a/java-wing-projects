package run.wing.model.dao;

import com.mysql.jdbc.MysqlSavepoint;
import run.wing.db.JdbcMysql;
import run.wing.model.to.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiana on 12/26/17.
 */
public class PersonDao {
    public PersonDao() {
        this.createTable();
    }

    private void createTable() {
        Connection connection = JdbcMysql.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String createTableSql =
                    "CREATE TABLE Person(" +
                            "id INT NOT NULL AUTO_INCREMENT," +
                            "name VARCHAR(40)," +
                            "lname VARCHAR(30)," +
                            "age INT," +
                            "createdAt DATETIME," +
                            "PRIMARY KEY (id))";

            statement.execute(createTableSql);

            System.out.println("Person Table is created");
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

    public void save(Person person) {
        Connection connection = JdbcMysql.getConnection();
        PreparedStatement statement = null;
        Savepoint savepoint = null;
        try {

//            connection.setAutoCommit(false);
//            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
//
            String insertInto = "INSERT INTO Person(name,lname,age,createdAt) VALUES (?,?,?,?)";
            statement = connection.prepareStatement(insertInto);
            statement.setString(1, person.getFname());
            statement.setString(2, person.getLname());
            statement.setInt(3, person.getAge());
            statement.setDate(4, new Date(System.currentTimeMillis()));
            statement.executeUpdate();

            //           savepoint = connection.setSavepoint("savePoint1");

//            String insertInto2 = "INSERT INTO Person(name,lname,age,createdAt) VALUES (?,?,?,?)";
//            statement = connection.prepareStatement(insertInto2);
//            statement.setString(1, person.getFname());
//            statement.setString(2, person.getLname());
//            statement.setInt(3, person.getAge());
//            statement.setDate(4, new Date(System.currentTimeMillis()));
//            statement.executeUpdate();
//
//            connection.commit();

            System.out.println("A person is inserted");
        } catch (SQLException e) {
//            try {
//                connection.rollback(savepoint);
//            } catch (SQLException e1) {
//                e1.printStackTrace();
//            }
            e.printStackTrace();
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


    public void update(Person person) {

        Connection connection = JdbcMysql.getConnection();
        PreparedStatement preparedStatement = null;
        String updateTable = "UPDATE Person SET name=?,lname=?,age=? WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(updateTable);
            preparedStatement.setString(1, person.getFname());
            preparedStatement.setString(2, person.getLname());
            preparedStatement.setInt(3, person.getAge());
            preparedStatement.setInt(4, person.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        System.out.println("Table is updated.");
    }

    public void delete(int id) {
        //delete duplicates in table
        Connection connection = JdbcMysql.getConnection();
        PreparedStatement preparedStatement = null;
        String deleteRecord = "DELETE FROM Person WHERE id=?";


        try {
            preparedStatement = connection.prepareStatement(deleteRecord);

            preparedStatement.setInt(1, id);

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
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Record is deleted");

    }

    public List<Person> tenLastPerson() {
        Connection connection = JdbcMysql.getConnection();
        PreparedStatement preparedStatement = null;
        List<Person> people = new ArrayList<>();
        String tenLastPerson = "SELECT * FROM Person ORDER BY age DESC LIMIT 10;";
        try {
            preparedStatement = connection.prepareStatement(tenLastPerson);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                people.add(new Person(resultSet.getString("name"), resultSet.getInt("id"),
                        resultSet.getString("lname"), resultSet.getInt("age"),
                        resultSet.getDate("createdAt")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        System.out.println("Ten last persons on Table : ");
        return people;
    }


    public float getPersonAgeAvg() {
        Connection connection = JdbcMysql.getConnection();
        PreparedStatement preparedStatement = null;
        List<Person> personList = new ArrayList<>();
        float f = 0.0f;

        String ageAvg = "SELECT avg(age) AS AgeAvg FROM Person";
        try {
            preparedStatement = connection.prepareStatement(ageAvg);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                f = resultSet.getFloat("AgeAvg");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        System.out.println();
        return f;
    }


    public int getPersonCount() {
        Connection connection = JdbcMysql.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        String personCount = "SELECT COUNT(id) AS count FROM Person";

        try {
            preparedStatement = connection.prepareStatement(personCount);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                count = resultSet.getInt("count");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        return count;
    }


    public Person find(int id) {
        Connection connection = JdbcMysql.getConnection();
        PreparedStatement preparedStatement = null;
        Person person = null;
        String findPerson = "SELECT * FROM Person WHERE id=?";
        try {
            preparedStatement = connection.prepareStatement(findPerson);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                person = new Person(
                        resultSet.getString("name"),
                        resultSet.getInt("id"),
                        resultSet.getString("lname"),
                        resultSet.getInt("age"),
                        resultSet.getDate("createdAt")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        return person;
    }

    public List<Person> findAll() {

        Connection connection = JdbcMysql.getConnection();
        PreparedStatement preparedStatement = null;
        List<Person> persons = new ArrayList<>();
        String findPerson = "SELECT * FROM Person";
        try {
            preparedStatement = connection.prepareStatement(findPerson);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                persons.add(new Person(
                        resultSet.getString("name"),
                        resultSet.getInt("id"),
                        resultSet.getString("lname"),
                        resultSet.getInt("age"),
                        resultSet.getDate("createdAt")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        return persons;
    }

    public void insertBatch() {
        String sql1 = "INSERT INTO Person(name,lname,age,createdAt) VALUES ('yusef','Shiri',26,CURDATE())";
        String sql2 = "INSERT INTO Person(name,lname,age,createdAt) VALUES ('Neda','Golshan',32,CURDATE())";
        String sql3 = "INSERT INTO Person(name,lname,age,createdAt) VALUES ('Ramtin','Rostami',25,CURDATE())";
        String sql4 = "INSERT INTO Person(name,lname,age,createdAt) VALUES ('Reza','Aminorraaaya',37,CURDATE())";

        Statement statement = null;
        Connection connection = JdbcMysql.getConnection();
        try {
            statement = connection.createStatement();
            connection.setAutoCommit(false);
            //Transaction block
            statement.addBatch(sql1);
            statement.addBatch(sql2);
            statement.addBatch(sql3);
            statement.addBatch(sql4);

            statement.executeBatch();

            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
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

}


//            For deleting duplicates
//            mysql> delete p1 from Person p1,Person p2 where p1.name = p2.name and p1.lname = p2.lname and p1.id> p2.id;
//                    Query OK, 22 rows affected (0.11 sec)