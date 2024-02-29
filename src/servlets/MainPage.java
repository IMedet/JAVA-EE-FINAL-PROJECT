package servlets;

import db.DBManager;
import db.News;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;


@WebServlet(value = "/mainPage")
public class MainPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<News> news = DBManager.getAllNews();
        req.setAttribute("news",news);
        req.getRequestDispatcher("main.jsp").forward(req,resp);
    }
}
