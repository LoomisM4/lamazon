package dhbw.lamazon.beans;

import dhbw.lamazon.entities.Article;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * liefert die Fachlogik für Article-Objekte
 */
@Stateless
public class ArticleBean {
    @PersistenceContext
    EntityManager em;

    /**
     * Diese Methode liefert alle in der Datenbank vorhandenen Artikel
     *
     * @return eine Liste mit Artikeln
     */
    public List<Article> getAllArticles() {
        return em.createQuery("SELECT a FROM Article a").getResultList();
    }

    /**
     * Sucht einen Artikel anhand eines übergebenen Titels
     *
     * @param title der Titel nach dem gesucht werden soll
     *
     * @return eine Liste mit gefundenen Artikeln
     */
    public List<Article> findArticleByTitle(String title) {
        return em.createQuery("SELECT a FROM Article a WHERE a.title LIKE :title")
                .setParameter("title", "%" + title + "%")
                .getResultList();
    }

    /**
     * Erstellt einen neuen Artikel und speichert diesen in der Datenbank
     *
     * @param title der Titel des neuen Artikels
     * @param descirption die Beschreibung des Artikels
     * @param price der gewünschte Preis des Artikels
     * @param user die ID des Benutzers, der den Artikel erstellen möchte
     */
    public void createNewArticle(String title, String descirption, double price, long user) {
        Article article = new Article();
        article.setTitle(title);
        article.setDescription(descirption);
        article.setPrice(price);
        article.setUser(user);

        em.persist(article);
    }
}