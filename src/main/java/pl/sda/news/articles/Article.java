package pl.sda.news.articles;


import pl.sda.news.comments.Comment;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;

    @Column(length = 2048)
    private String content;
    private LocalDateTime publishDate;

    @OneToMany(mappedBy = "articleId")
    private List<Comment> comments;

    public Article(String title, String content, LocalDateTime publishDate) {
        this.title = title;
        this.content = content;
        this.publishDate = publishDate;
        this.comments = new ArrayList<>();
    }

    public Article() {
    }


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public List<Comment> getComments() {
        if (comments == null) {
            comments = new ArrayList<>();
        }
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
