package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        Util util = new Util();
        try {
            Statement statement = util.getConnection().createStatement();
            statement.execute("CREATE TABLE users (id int not null primary key, name VARCHAR(40), last_name VARCHAR(40), age INT, primary key (id)) IF NOT EXISTS");
            util.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        Util util = new Util();
        try {
            Statement statement = util.getConnection().createStatement();
            statement.execute("DROP TABLE IF EXISTS users");
            util.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        Util util = new Util();
        try {
            PreparedStatement preparedStatement = util.getConnection().prepareStatement(
                    "INSERT INTO users (name, last_name, age) VALUES (?, ?, ?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
            util.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        Util util = new Util();
        try {
            PreparedStatement preparedStatement = util.getConnection().prepareStatement(
                    "DELETE FROM users where id=?");
            preparedStatement.setLong(1, id);
            util.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        Util util = new Util();
        List<User> result = new ArrayList<>();
        try {
            Statement statement = util.getConnection().createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                User user = new User(rs.getString("name"), rs.getString("last_name"), rs.getByte("age"));

                result.add(user);
            }
            util.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void cleanUsersTable() {
        Util util = new Util();
        try {
            Statement statement = util.getConnection().createStatement();
            statement.execute("DELETE FROM users");
            util.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
