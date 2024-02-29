package db;

import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/final", "postgres", "00000000");
        }catch (Exception e){
            System.out.println("You have some error");
            e.printStackTrace();
        }
    }


    public static void addUser(User user){
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users " +
                    "(email,password,full_name,role_id) " +
                    "VALUES (?,?,?,?) ");
            statement.setString(1,user.getEmail());
            statement.setString(2,user.getPassword());
            statement.setString(3,user.getFull_name());
            statement.setString(4,user.getRole_id());

            statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addNews(News news){
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO news " +
                    "(postdate,title,content,user_id) " +
                    "VALUES (CURRENT_TIMESTAMP,?,?,?) ");
            statement.setString(1,news.getTitle());
            statement.setString(2,news.getContent());
            statement.setLong(3,news.getUser().getId());

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void deleteNews(News news){
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE from comments WHERE news_id = ? ");
            statement.setLong(1,news.getId());
            statement.executeUpdate();

            PreparedStatement statement1 = connection.prepareStatement("DELETE from news WHERE id = ? ");
            statement1.setLong(1,news.getId());
            statement1.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean addComment(Comment comment){
        int rows = 0;
        try {

            PreparedStatement statement = connection.prepareStatement("INSERT INTO comments " +
                    "(comment,postdate,user_id,news_id) " +
                    "VALUES (?,CURRENT_TIMESTAMP,?,?) ");
            statement.setString(1,comment.getComment());
            statement.setLong(2, comment.getUser().getId());
            statement.setLong(3, comment.getNews().getId());

            rows = statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows>0;
    }

    public static News getNewsById(Long id){
        News news = new News();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT n.*, u.full_name " +
                    "from news AS n " +
                    "INNER JOIN users AS u on u.id = n.user_id " +
                    "WHERE n.id = ?");
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                news.setId(resultSet.getLong("id"));
                news.setPostdate(resultSet.getTimestamp("postdate"));
                news.setTitle(resultSet.getString("title"));
                news.setContent(resultSet.getString("content"));

                User user = new User();
                user.setFull_name(resultSet.getString("full_name"));
                news.setUser(user);

            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return news;
    }

    public static ArrayList<Comment> getCommentsByNewsId(Long id){
        ArrayList<Comment> comments = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT c.id, c.comment , c.postdate , u.id AS user_id, u.full_name " +
                    "FROM comments AS c " +
                    "INNER JOIN users AS u on c.user_id = u.id " +
                    "WHERE c.news_id = ?");
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Comment comment = new Comment();
                comment.setId(resultSet.getLong("id"));
                comment.setComment(resultSet.getString("comment"));
                comment.setPostdate(resultSet.getTimestamp("postdate"));

                User user = new User();
                user.setFull_name(resultSet.getString("full_name"));
                comment.setUser(user);

                comments.add(comment);
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return comments;
    }

    public static ArrayList<News> getAllNews(){
        ArrayList<News> newses = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT n.*,u.full_name " +
                    "FROM news AS n " +
                    "INNER JOIN users AS u on u.id = n.user_id " +
                    "ORDER BY n.postdate DESC ");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                News news = new News();
                news.setId(resultSet.getLong("id"));
                news.setContent(resultSet.getString("content"));
                news.setTitle(resultSet.getString("title"));
                news.setPostdate(resultSet.getTimestamp("postdate"));

                User user = new User();
                user.setFull_name(resultSet.getString("full_name"));

                news.setUser(user);

                newses.add(news);
            }

            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return newses;
    }

    public static User getUser(String email){
        User user = new User();
        try {
            PreparedStatement statement = connection.prepareStatement("Select * from users Where email = ?");
            statement.setString(1,email);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                user.setId(resultSet.getLong("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setFull_name(resultSet.getString("full_name"));
                user.setRole_id(resultSet.getString("role_id"));
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return user;
    }
}
