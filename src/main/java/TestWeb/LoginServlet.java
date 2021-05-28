package TestWeb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name="Login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = UserAuthentication.findCookie(req.getCookies());

        if(UserAuthentication.checkCookie(cookie))
            resp.sendRedirect("/home");
        req.getRequestDispatcher("Login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("username");
        String password = req.getParameter("password");
                                                                                //open database
        try {
            Database database = new Database();
            try {
                if(database.searchForUser(email, password)) {
                    Cookie loginCookie = new Cookie("loginCookie", email);      //create a "login in cookie"
                    loginCookie.setMaxAge(43_200);                              //sets how long the cookies last until they expire
                    resp.addCookie(loginCookie);                                //adds cookie to an array of cookies
                    resp.sendRedirect("/home");
                } else {
                    req.setAttribute("loginError", "Bad Credentials");          //sets the string loginError to be Bad credentials
                    req.getRequestDispatcher("Login.jsp").forward(req, resp);   //renders and sends the Login.jsp page to user
                }
            } finally {
                database.close();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


}
