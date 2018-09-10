package pl.coderslab.controller;

import pl.coderslab.model.Group;
import pl.coderslab.utils.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;

import static pl.coderslab.dao.GroupDao.loadAllGroups;

@WebServlet(name = "AllGroups", urlPatterns = "/AllGroups")
public class AllGroups extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Group group = new Group();

        try {
            ArrayList<Group> allGroups = loadAllGroups();
            request.setAttribute("allGroups", allGroups);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/WEB-INF/jsp/allGroups.jsp").forward(request,response);
    }
}
