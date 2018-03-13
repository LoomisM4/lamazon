package dhbw.lamazon.beans;

import dhbw.lamazon.entities.Article;
import dhbw.lamazon.entities.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * liefert die Fachlogik für Article-Objekte
 *
 * @author Marcel Wettach
 */
@Stateless
@SuppressWarnings("unchecked")
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
     * Liefert den Atikel mit der übergebenen ID zurück
     *
     * @param id die ID des zu suchenden Artikels
     *
     * @return ein Artikel-Objekt, falls ein passender Artikel gefunden wurde
     */
    public Article findArticleById(long id) {
        return em.find(Article.class, id);
    }

    /**
     * Sucht alle von einem bestimmten Nutzer eingestellten Artikel
     *
     * @param user das User-Objekt des Benutzers, der die Artikel eingestellt hat
     *
     * @return eine Liste mit von dem Benutzer eingestellten Artikeln
     */
    public List<Article> findArticlesByUser(User user) {
        return em.createQuery("SELECT a FROM Article a WHERE a.user = :user")
                .setParameter("user", user)
                .getResultList();
    }

    /**
     * Erstellt einen neuen Artikel und speichert diesen in der Datenbank
     *
     * @param title der Titel des neuen Artikels
     * @param descirption die Beschreibung des Artikels
     * @param price der gewünschte Preis des Artikels
     * @param user das User-Objekt des Benutzers, der den Artikel erstellen möchte
     */
    public void createNewArticle(String title, String descirption, double price, User user) {
        Article article = new Article();
        article.setTitle(title);
        article.setDescription(descirption);
        article.setPrice(price);
        article.setUser(user);

        em.persist(article);
    }
}
