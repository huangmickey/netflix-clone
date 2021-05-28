package TestWeb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name="AccountInfo", urlPatterns="/account")
public class AccountInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = UserAuthentication.findCookie(req.getCookies());
        String email = cookie.getValue();
        try {
            Database database = new Database();
            try {
                UserData userData = database.getData(email);
                req.setAttribute("userData", userData);
                req.getRequestDispatcher("AccountInfo.jsp").forward(req, resp);
            } finally {
                database.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = UserAuthentication.findCookie(req.getCookies());
        String email = cookie.getValue();
        String password = req.getParameter("password");
        String firstName = req.getParameter("first-name");
        String lastName = req.getParameter("last-name");
        try {
            Database database = new Database();
            try {
                UserData userData = database.getData(email);
                if(password.isEmpty())
                    password = userData.getPassword();
                if(firstName.isEmpty())
                    firstName = userData.getFirstName();
                if(lastName.isEmpty())
                    lastName = userData.getLastName();
                database.editData(email, password, firstName, lastName);
            } finally {
                database.close();
            }
            resp.sendRedirect("/home");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}
