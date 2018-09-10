package pl.coderslab.controller;

import pl.coderslab.model.Exercise;
import pl.coderslab.utils.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static pl.coderslab.dao.ExerciseDao.loadAllExercises;
import static pl.coderslab.dao.ExerciseDao.saveExeToDb;


@WebServlet(name = "AdmExe", urlPatterns = "/admExe")
public class AdmExe extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        int id = Integer.parseInt(request.getParameter("id"));
        Exercise exercise = new Exercise(title, description, id);
        try {
            saveExeToDb(exercise);
        } catch (SQLException e) {

        }
        response.sendRedirect("/admExe");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            ArrayList<Exercise> exe = loadAllExercises();
            request.setAttribute("exe", exe);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/admExe.jsp").forward(request, response);
    }
}
