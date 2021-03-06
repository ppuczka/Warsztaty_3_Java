package pl.coderslab.controller;

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

import static pl.coderslab.dao.UserDao.loadAllUsersByGroupId;

@WebServlet(name = "UserByGroupID", urlPatterns = "/UserGroup")

public class UserByGroupID extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        try {
            ArrayList<User> users = loadAllUsersByGroupId(id);
            request.setAttribute("users", users);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/userGroup.jsp").forward(request,response);

    }
}

