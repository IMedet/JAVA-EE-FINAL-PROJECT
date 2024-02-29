package db;

import java.sql.Timestamp;

public class Comment {
    private Long id;
    private String comment;
    private Timestamp postdate;
    private User user;
    private News news;

    public Comment() {
    }

    public Comment(Long id, String comment, Timestamp postdate, User user, News news) {
        this.id = id;
        this.comment = comment;
        this.postdate = postdate;
        this.user = user;
        this.news = news;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getPostdate() {
        return postdate;
    }

    public void setPostdate(Timestamp postdate) {
        this.postdate = postdate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }
}
