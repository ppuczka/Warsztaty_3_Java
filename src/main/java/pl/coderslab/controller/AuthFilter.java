package pl.coderslab.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "AuthFilter")
public class AuthFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {

    }
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String password = req.getParameter("password");
        if(password.equals("coderslab")) {
            chain.doFilter(req, resp);

        }else
            out.print("Nazwa użytkownika lub hasło niepoprawne");
            RequestDispatcher rd = req.getRequestDispatcher("auth.jsp");
            rd.include(req, resp);

    }



}
