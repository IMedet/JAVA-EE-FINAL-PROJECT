package servlets;

import db.Comment;
import db.DBManager;
import db.News;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/comments")
public class CommentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        News news = DBManager.getNewsById(id);
        req.setAttribute("news",news);

        ArrayList<Comment> comments = DBManager.getCommentsByNewsId(id);
        req.setAttribute("comments",comments);

        req.getRequestDispatcher("comment.jsp").forward(req,resp);
    }
}
