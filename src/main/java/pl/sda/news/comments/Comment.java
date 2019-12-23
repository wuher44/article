package pl.sda.news.comments;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
public class Comment {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String author;
    @Column(length = 512)
    private String content;
    private LocalDateTime creationDate;
    private long articleId;

    public Comment(String author, String content, LocalDateTime creationDate, long articleId) {
        this.author = author;
        this.content = content;
        this.creationDate = creationDate;
        this.articleId = articleId;
    }

    public Comment() {
    }

    public long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public long getArticleId() {
        return articleId;
    }
}
