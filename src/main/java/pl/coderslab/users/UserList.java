package pl.coderslab.users;

import pl.coderslab.classes.User;
import pl.coderslab.classes.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/user/list")
public class UserList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserDao userDao = new UserDao();
        User[] users = userDao.findAll();
        request.setAttribute("users",users);
        getServletContext().getRequestDispatcher("/users/list.jsp").forward(request, response);
    }
}
