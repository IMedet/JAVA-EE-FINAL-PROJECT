package servlets;

import db.DBManager;
import db.News;
import db.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/addNews")
public class AddNewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("CURRENT_USER");
        if(user!=null && user.getRole_id().equals("1")) {
            req.getRequestDispatcher("addNews.jsp").forward(req, resp);
        }else{
            resp.sendRedirect("/signin");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("CURRENT_USER");
        Long user_id = user.getId();
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        News news = new News();
        news.setTitle(title);
        news.setContent(content);
        news.setUser(user);


        DBManager.addNews(news);
        resp.sendRedirect("/mainPage");
    }
}
