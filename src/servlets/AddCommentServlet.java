package servlets;

import db.Comment;
import db.DBManager;
import db.News;
import db.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/addComment")
public class AddCommentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("CURRENT_USER");
        Long id = Long.valueOf(req.getParameter("id"));
        req.setAttribute("id",id);
        if(user!=null){
            req.getRequestDispatcher("addComment.jsp").forward(req,resp);
        }else{
            resp.sendRedirect("/signin");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("CURRENT_USER");
        String com = req.getParameter("comment");
        Comment comment = new Comment();
        comment.setComment(com);

        News news = new News();
        news.setId(Long.valueOf(req.getParameter("news_id")));

        comment.setNews(news);
        comment.setUser(user);

        DBManager.addComment(comment);
        resp.sendRedirect("/home");
    }
}
