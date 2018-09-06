package pl.coderslab.controller;

import pl.coderslab.model.Group;
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

import static pl.coderslab.model.User.loadAllUsers;

@WebServlet(name = "AdmUser", urlPatterns = "/admUser")
public class AdmUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        int id = Integer.parseInt(request.getParameter("id"));
        User user = new User(id, userName, email, pass);
        try {
            user.saveUserToDB(DbUtil.getConn());
        } catch (SQLException e) {

        }
        response.sendRedirect("/admUser");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            ArrayList<User> users = loadAllUsers(DbUtil.getConn());
            request.setAttribute("users", users);

        } catch (SQLException e ) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/admUsers.jsp").forward(request, response);
    }
}
