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

    public List<Article> getAllArticles() {
        return em.createQuery("SELECT a FROM Article a").getResultList();
    }

    public List<Article> findArticleByTitle(String title) {
        return em.createQuery("SELECT a FROM Article a WHERE a.title LIKE :title")
                .setParameter("title", "%" + title + "%")
                .getResultList();
    }

    public void createNewArticle(String title, String descirption, double price, long user) {
        Article article = new Article();
        article.setTitle(title);
        article.setDescription(descirption);
        article.setPrice(price);
        article.setUser(user);

        em.persist(article);
    }
}
