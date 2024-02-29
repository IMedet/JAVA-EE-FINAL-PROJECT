package db;

import java.sql.Timestamp;

public class News {
    private Long id;
    private Timestamp postdate;
    private String title;
    private String content;
    private User user;

    public News() {
    }

    public News(Long id, Timestamp postdate, String title, String content, User user) {
        this.id = id;
        this.postdate = postdate;
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getPostdate() {
        return postdate;
    }

    public void setPostdate(Timestamp postdate) {
        this.postdate = postdate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
