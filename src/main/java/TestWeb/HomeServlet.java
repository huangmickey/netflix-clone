package TestWeb;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="Home", urlPatterns = "/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = UserAuthentication.findCookie(req.getCookies());

        if(UserAuthentication.checkCookie(cookie)) {
            req.setAttribute("userName", cookie.getValue());
            req.getRequestDispatcher("Home.jsp").forward(req, resp);
        }
        resp.sendRedirect("/");
    }



}
