package pl.coderslab.dao;

import pl.coderslab.model.Group;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GroupDao {

    public static void saveGrouptoDB(Group group) throws SQLException {
        if (group.groupId == 0) {
            String sql = "INSERT INTO User_group(name) VALUES(?)";
            Connection conn = DbUtil.getConn();
            String generatedColumns[] = {"ID"};
            PreparedStatement ps = conn.prepareStatement(sql, generatedColumns);
            ps.setString(1, group.name);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                group.groupId = rs.getInt(1);
            }

        } else {
            String sql = "UPDATE User_group SET name=? WHERE id = ?";
            Connection conn = DbUtil.getConn();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, group.name);
            ps.setInt(2, group.groupId);
            ps.executeUpdate();

        }
    }

    public static void deleteGroup(Group group) throws SQLException {
        if (group.groupId != 0) {
            Connection conn = DbUtil.getConn();
            String sql = "DELETE FROM User_group WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, group.groupId);
            ps.executeUpdate();
            group.groupId = 0;
        }
    }

    public static ArrayList<Group> loadAllGroups() throws SQLException {
        ArrayList<Group> groups = new ArrayList<>();
        String sql = "SELECT * FROM User_group";
        Connection conn = DbUtil.getConn();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            Group loadedGroup = new Group();
            loadedGroup.groupId = rs.getInt("id");
            loadedGroup.name = rs.getString("name");
            groups.add(loadedGroup);

        }
        return groups;
    }

}

