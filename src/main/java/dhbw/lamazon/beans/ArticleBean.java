package dhbw.lamazon.beans;

import dhbw.lamazon.entities.Article;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ArticleBean {
    @PersistenceContext
    EntityManager em;

    public List<Article> findAllArticles() {
        // List<Article> articles = em.createQuery("SELECT a FROM Articles a", Article.class).getResultList();
        // return articles;
        return null;
    }

    public Article findArticleById(long id) {
        return em.find(Article.class, id);
    }

}
