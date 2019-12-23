package pl.sda.news.articles;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ArticlesController {


    private ArticleRepository articleRepository;

    public ArticlesController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("/article")
    String list(@RequestParam(required = false) String phrase, @RequestParam(required = false) boolean titleOnly,  Model model) {

        if (phrase == null || phrase.isEmpty()) {
            model.addAttribute("articles", articleRepository.findAll());
        } else {
            if (titleOnly) {
                List<Article> articles = articleRepository.searchInTitle(phrase);
                model.addAttribute("articles", articles);
                model.addAttribute("lastPhrase", phrase);

            } else {
                List<Article> articles = articleRepository.search(phrase);
                model.addAttribute("articles", articles);
                model.addAttribute("lastPhrase", phrase);

            }
            return "article/list";
        }
        return "article/list";
    }

    @PostMapping(value = "/article", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    String createArticle(@RequestParam String title, @RequestParam String content) {


        Article article = new Article(title, content, LocalDateTime.now());
        articleRepository.save(article);
        return "redirect:/article";
    }

    @GetMapping("/article/add")
    String addArticleForm() {
        return "article/add";
    }

    @GetMapping("article/{id}")
    String displayArticle(@PathVariable Long id, Model model) {
        Article article = articleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Article not found"));
        model.addAttribute("article", article);
        return "article/details";
    }
    @GetMapping("/start")
    String start(){
        return "article/start";


    }


}
