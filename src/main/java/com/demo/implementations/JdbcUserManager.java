package com.demo.implementations;
import com.demo.connection.MySQLConnectionUtility;
import com.demo.interfaceManager.UserManager;
import com.demo.model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class JdbcUserManager implements UserManager {
    public void addUser(User user) {
        Connection connection = MySQLConnectionUtility.getConnection();
        String sql = "insert into User values(?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getGender());
            ps.setString(4, user.getDob());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Exception found");
        }
    }

    public void updateUser(User user) {
        Connection connection = MySQLConnectionUtility.getConnection();
        String sql = "update user set name=?,gender=?,dob=? where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getGender());
            ps.setString(3, user.getDob());
            ps.setInt(4, user.getId());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Exception found");
        }
    }

    public void deleteUser(String name) {
        Connection connection = MySQLConnectionUtility.getConnection();
        String sql = "DELETE FROM user WHERE name=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Exception found");
        }
    }

    public List<User> listUsers() {
        List<User> userList = new ArrayList<>();
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM User");
            while (resultSet.next()) {

                int id = resultSet.getInt("ID");
                String name = resultSet.getString("NAME");
                String gender = resultSet.getString("GENDER");
                String dob = resultSet.getString("DOB");
                userList.add(new User(id, name, gender, dob));
            }
        } catch (SQLException e) {
            System.out.println("Exception found");
        }
        return userList;
    }

    public List<User> searchUsers(String username) {
        List<User> searchList = new ArrayList<>();
        Connection connection = MySQLConnectionUtility.getConnection();
        String sql = "select * from user where name like ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                String dob = resultSet.getString("dob");
                searchList.add(new User(id, name, gender, dob));
            }
        } catch (SQLException e) {
            System.out.println("Exception found");
        }
        return searchList;
    }
}



