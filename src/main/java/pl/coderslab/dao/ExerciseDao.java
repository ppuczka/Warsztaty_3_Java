package pl.coderslab.dao;

import pl.coderslab.model.Exercise;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ExerciseDao {

    public static ArrayList<Exercise> loadAllExercises() throws SQLException {

        ArrayList<Exercise> exercises = new ArrayList<>();
        String sql = "SELECT * FROM exercise";
        Connection conn = DbUtil.getConn();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Exercise loadedExcercise = new Exercise();
            loadedExcercise.id = rs.getInt("id");
            loadedExcercise.title = rs.getString("title");
            loadedExcercise.description = rs.getString("description");
            exercises.add(loadedExcercise);
        }

        return exercises;

    }

    public static void saveExeToDb(Exercise exercise) throws SQLException {

        if (exercise.id == 0) {
            String sql = "INSERT INTO exercise (title, description) VALUES (?,?)";
            String generatedColumns[] = {"ID"};
            Connection conn = DbUtil.getConn();
            PreparedStatement ps = conn.prepareStatement(sql, generatedColumns);
            ps.setString(1, exercise.title);
            ps.setString(2, exercise.description);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                exercise.id = rs.getInt(1);

            }

        } else {

            String sql = "UPDATE exercise SET title =?, description =? WHERE id = ?";
            Connection conn = DbUtil.getConn();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, exercise.title);
            ps.setString(2, exercise.description);
            ps.setInt(3, exercise.id);
            ps.executeUpdate();
        }
    }
}

