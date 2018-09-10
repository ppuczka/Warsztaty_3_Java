package pl.coderslab.dao;

import pl.coderslab.model.Solution;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SolutionDao {

    public static ArrayList<Solution> loadAllSolutions() throws SQLException {

        ArrayList<Solution> solutions = new ArrayList<>();
        String sql = "SELECT * FROM Solution";
        Connection conn = DbUtil.getConn();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Solution loadedSolution = new Solution();
            loadedSolution.id = rs.getInt("id");
            loadedSolution.created = rs.getDate("created");
            loadedSolution.updated = rs.getDate("updated");
            loadedSolution.description = rs.getString("description");
            loadedSolution.exercise_id = rs.getInt("excercise_id");
            loadedSolution.users_id = rs.getInt("users_id");
            solutions.add(loadedSolution);

        }
        return solutions;
    }

    public static ArrayList<Solution> loadLimitSolutions(int limit) throws SQLException {

        ArrayList<Solution> solutions = new ArrayList<>();
        String sql = "Select * FROM Solution ORDER BY updated DESC LIMIT 5";
        Connection conn = DbUtil.getConn();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Solution loadedSolution = new Solution();
            loadedSolution.id = rs.getInt("id");
            loadedSolution.created = rs.getDate("created");
            loadedSolution.updated = rs.getDate("updated");
            loadedSolution.description = rs.getString("description");
            loadedSolution.exercise_id = rs.getInt("excercise_id");
            loadedSolution.users_id = rs.getInt("users_id");
            solutions.add(loadedSolution);

        }
        return solutions;

    }

    public static Solution loadSolutionById(int id) throws SQLException {

        String sql = "SELECT * FROM Solution WHERE id = ?";
        Connection conn = DbUtil.getConn();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Solution loadedSolution = new Solution();
            loadedSolution.id = rs.getInt("id");
            loadedSolution.created = rs.getDate("created");
            loadedSolution.updated = rs.getDate("updated");
            loadedSolution.description = rs.getString("description");
            loadedSolution.exercise_id = rs.getInt("excercise_id");
            loadedSolution.users_id = rs.getInt("users_id");
            return loadedSolution;
        }
        return null;

    }

    public static ArrayList<Solution> loadAllSolutionsByUserID(int users_id) throws SQLException {

        ArrayList<Solution> solutionsById = new ArrayList<>();
        String sql = "SELECT * FROM solution JOIN users ON solution.users_id = users.id WHERE users.id = ?";
        Connection conn = DbUtil.getConn();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, users_id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            while (rs.next()) {
                Solution allById = new Solution();
                allById.id = rs.getInt("id");
                allById.created = rs.getDate("created");
                allById.updated = rs.getDate("updated");
                allById.description = rs.getString("description");
                allById.exercise_id = rs.getInt("excercise_id");
                allById.users_id = rs.getInt("users_id");
                allById.username = rs.getString("username");
                allById.email = rs.getString("email");
                solutionsById.add(allById);

            }
            return solutionsById;
        }
        return null;

    }
}
