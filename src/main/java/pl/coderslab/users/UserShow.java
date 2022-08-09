package pl.coderslab.users;

import pl.coderslab.classes.User;
import pl.coderslab.classes.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/show")
public class UserShow extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        UserDao userDao = new UserDao();
        try {
            User read = userDao.read(Integer.parseInt(id));
            request.setAttribute("user", read);
            getServletContext().getRequestDispatcher("/users/show.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            response.sendRedirect(request.getContextPath() + "/user/list");
        }
    }
}
