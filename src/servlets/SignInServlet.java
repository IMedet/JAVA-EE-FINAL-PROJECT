package servlets;

import db.DBManager;
import db.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/signin")
public class SignInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("sign.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String redirect = "/signIn?ERROR";
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = DBManager.getUser(email);

        if(user!=null && user.getEmail().equals(email) && user.getPassword().equals(password)){
            redirect="/mainPage";
            req.getSession().setAttribute("CURRENT_USER",user);
        }
        resp.sendRedirect(redirect);
    }
}
