package pl.sda.news.comments;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.time.LocalDateTime;

@Controller
public class CommentsController {
    private final CommentsRepository commentsRepository;

    public CommentsController(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    @PostMapping(value = "/comment", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    String listComments(@RequestParam Long articleId, @RequestParam String author, @RequestParam String content) {

        Comment comment = new Comment(author, content, LocalDateTime.now(), articleId);

        commentsRepository.save(comment);
        return "redirect:/article/"+articleId;
    }


}
