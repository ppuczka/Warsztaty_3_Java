package pl.coderslab.controller;

import pl.coderslab.model.Solution;
import pl.coderslab.utils.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


@WebServlet(name = "StartPage", urlPatterns = "/")
public class StartPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Solution solution = new Solution();

        int limit = Integer.parseInt(getServletContext().getInitParameter("number-solutions"));

        try {
            ArrayList<Solution> PrintSolutions = solution.loadAllSolutions(DbUtil.getConn(), limit);
            request.setAttribute("loadAllSolutions", PrintSolutions);

        } catch (SQLException e) {

            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request, response);
    }
}
