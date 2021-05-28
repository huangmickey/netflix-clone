package TestWeb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name="Register", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Getting servlet request URL
        String url = req.getRequestURL().toString();

        // Getting servlet request query string.
        String queryString = req.getQueryString();

        // Getting request information without the hostname.
        String uri = req.getRequestURI();

        // Below we extract information about the request object path
        // information.
        String scheme = req.getScheme();
        String serverName = req.getServerName();
        int portNumber = req.getServerPort();
        String contextPath = req.getContextPath();
        String servletPath = req.getServletPath();
        String pathInfo = req.getPathInfo();
        String query = req.getQueryString();

        resp.setContentType("text/html");
        System.out.println("Url: " + url);
        System.out.println("Uri: " + uri);
        System.out.println("Scheme: " + scheme);
        System.out.println("Server Name: " + serverName);
        System.out.println("Port: " + portNumber);
        System.out.println("Context Path: " + contextPath);
        System.out.println("Servlet Path: " + servletPath);
        System.out.println("Path Info: " + pathInfo);
        System.out.println("Query: " + query);
        System.out.println("==========================");

        Cookie cookie = UserAuthentication.findCookie(req.getCookies());
        if(query == null) {
            resp.sendRedirect("/");
        }
        else if(UserAuthentication.checkCookie(cookie)) {
            resp.sendRedirect("/home");
        }
        else {
            req.getRequestDispatcher("Register.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //do some validation , if good add to database else update jsp page and reload to user
        String email = req.getParameter("username");
        String firstName = req.getParameter("first-name");
        String lastName = req.getParameter("last-name");
        String password = req.getParameter("password");

        try {
            Database database = new Database();
            try {
                database.addUser(email, password, firstName, lastName);
            } finally {
                database.close();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/login");

    }
}
