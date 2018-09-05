package pl.coderslab.controller;

import pl.coderslab.model.Solution;
import pl.coderslab.model.User;
import pl.coderslab.utils.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "UserDetails", urlPatterns = "/UserDetails")
public class UserDetails extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int usrId = Integer.parseInt(request.getParameter("id"));


            try {
                ArrayList<Solution> userSolutions = Solution.loadAllSolutionsByUserID(DbUtil.getConn(), usrId);
                request.setAttribute("userSolutions", userSolutions);

                User user = User.loadUserById(DbUtil.getConn(), usrId);
                request.setAttribute("user", user);

            }catch (SQLException e) {
                e.printStackTrace();
            }
       getServletContext().getRequestDispatcher("/WEB-INF/jsp/user.jsp").forward(request, response);
    }
}
