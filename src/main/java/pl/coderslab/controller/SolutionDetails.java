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

@WebServlet(name = "SolutionDetails", urlPatterns = "/SolutionDetails")
public class SolutionDetails extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            int solId = Integer.parseInt(request.getParameter("id"));


            try {
                Solution solution = Solution.loadSolutionById(DbUtil.getConn(), solId);
                request.setAttribute("solution", solution);

            } catch (SQLException e)  {
                e.printStackTrace();
            }

            getServletContext().getRequestDispatcher("/WEB-INF/jsp/solution.jsp").forward(request,response);
    }
}
