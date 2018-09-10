package pl.coderslab.controller;

import pl.coderslab.model.Group;
import pl.coderslab.utils.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static pl.coderslab.dao.GroupDao.loadAllGroups;
import static pl.coderslab.dao.GroupDao.saveGrouptoDB;

@WebServlet(name = "AdmGroup", urlPatterns = "/admGroup")
public class AdmGroup extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String groupName = request.getParameter("groupName");
        int id = Integer.parseInt(request.getParameter("id"));
        Group group = new Group(id, groupName);
        try {
            saveGrouptoDB(group);
        } catch (SQLException e) {

        }
        response.sendRedirect("/admGroup");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            ArrayList<Group> groups = loadAllGroups();
            request.setAttribute("groups", groups);

        }catch (SQLException e) {
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/WEB-INF/jsp/admGroups.jsp").forward(request,response);

    }
}
