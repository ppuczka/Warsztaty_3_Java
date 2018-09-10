package pl.coderslab.dao;

import pl.coderslab.model.User;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao {

    public static void saveUserToDb(User user) throws SQLException {
        if (user.getId() == 0) {
            Connection conn = DbUtil.getConn();
            String sql = "INSERT INTO Users(username, email, password) VALUES (?, ?, ?)";
            String generatedColumns[] = {"ID"};
            PreparedStatement preparedStatement = conn.prepareStatement(sql, generatedColumns);
            preparedStatement.setString(1, user.username);
            preparedStatement.setString(2, user.email);
            preparedStatement.setString(3, user.password);
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                user.id = (rs.getInt(1));
            }
            conn.close();
        } else {
            Connection conn = DbUtil.getConn();
            String sql = "UPDATE Users SET username=?, email=?, password=? where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, user.username);
            preparedStatement.setString(2, user.email);
            preparedStatement.setString(3, user.password);
            preparedStatement.setInt(4, user.id);
            preparedStatement.executeUpdate();
            conn.close();

        }
    }

    public static void deleteUser(User user) throws SQLException {
        if (user.id != 0) {
            String sql = "DELETE FROM Users WHERE id= ?";
            Connection conn = DbUtil.getConn();
            PreparedStatement preparedStatement;
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, user.id);
            preparedStatement.executeUpdate();
            user.id = 0;
        }

    }

    public static User loadUserById(int id) throws SQLException {

        String sql = "SELECT * FROM Users where id=?";
        PreparedStatement preparedStatement;
        Connection conn = DbUtil.getConn();
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            User loadedUser = new User();
            loadedUser.id = resultSet.getInt("id");
            loadedUser.username = resultSet.getString("username");
            loadedUser.password = resultSet.getString("password");
            loadedUser.email = resultSet.getString("email");
            return loadedUser;
        }
        return null;
    }

    public static ArrayList<User> loadAllUsers() throws SQLException {

        ArrayList<User> users = new ArrayList<User>();
        String sql = "SELECT * FROM Users";
        Connection conn = DbUtil.getConn();
        PreparedStatement preparedStatement;
        preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            User loadedUser = new User();
            loadedUser.id = resultSet.getInt("id");
            loadedUser.username = resultSet.getString("username");
            loadedUser.password = resultSet.getString("password");
            loadedUser.email = resultSet.getString("email");
            users.add(loadedUser);
        }
        return users;
    }

    public static ArrayList<User> loadAllUsersByGroupId(int group_id) throws SQLException {
        ArrayList<User> loadedUsersByGroupId = new ArrayList<>();
        String sql = "SELECT * FROM users WHERE person_group_id = ?";
        Connection conn = DbUtil.getConn();
        PreparedStatement preparedStatement;
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, group_id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            User loadedUser = new User();
            loadedUser.id = resultSet.getInt("id");
            loadedUser.username = resultSet.getString("username");
            loadedUser.email = resultSet.getString("email");
            loadedUser.password = resultSet.getString("password");
            loadedUsersByGroupId.add(loadedUser);
        }
        return loadedUsersByGroupId;

    }


}
