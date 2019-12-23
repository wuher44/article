package pl.sda.news.articles;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Query("select a from Article a where a.title like %:phrase% or a.content like %:phrase% ")
    List<Article> search(@Param("phrase") String phrase);
    @Query("select a from Article a where a.title like %:phrase%")
    List<Article> searchInTitle(String phrase);
}
