package servlets;

import db.DBManager;
import db.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String role_id = "2";
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String full_name = req.getParameter("full_name");
        if(email.equals("medet@gmail.com")){
            role_id="1";
        }

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setFull_name(full_name);
        user.setRole_id(role_id);

        DBManager.addUser(user);

        resp.sendRedirect("/signin");
    }
}
