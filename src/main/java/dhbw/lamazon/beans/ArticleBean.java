package dhbw.lamazon.beans;

import dhbw.lamazon.Errors;
import dhbw.lamazon.entities.Article;
import dhbw.lamazon.entities.User;
import dhbw.lamazon.enums.Category;
import dhbw.lamazon.enums.UserCommunication;

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
    private EntityManager em;

    /**
     * Diese Methode liefert alle in der Datenbank vorhandenen Artikel
     *
     * @return eine Liste mit Artikeln
     */
    public synchronized List<Article> findAllArticles() {
        return em.createQuery("SELECT a FROM Article a").getResultList();
    }

    /**
     * Sucht einen Artikel anhand eines übergebenen Titels
     *
     * @param title der Titel nach dem gesucht werden soll
     *
     * @return eine Liste mit gefundenen Artikeln
     */
    public synchronized List<Article> findArticleByTitle(String title) {
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
    public synchronized Article findArticleById(long id) {
        return em.find(Article.class, id);
    }

    /**
     * Sucht alle von einem bestimmten Nutzer eingestellten Artikel
     *
     * @param user das User-Objekt des Benutzers, der die Artikel eingestellt hat
     *
     * @return eine Liste mit von dem Benutzer eingestellten Artikeln
     */
    public synchronized List<Article> findArticlesByUser(User user) {
        return em.createQuery("SELECT a FROM Article a WHERE a.user = :user")
                .setParameter("user", user)
                .getResultList();
    }

    /**
     * Erstellt einen neuen Artikel und speichert diesen in der Datenbank
     *
     * @param title der Titel des neuen Artikels
     * @param description die Beschreibung des Artikels
     * @param price der gewünschte Preis des Artikels
     * @param user das User-Objekt des Benutzers, der den Artikel erstellen möchte
     */
    public synchronized void createNewArticle(String title, String description, double price, User user, byte[] image, Category category) {
        Article article = new Article();
        article.setTitle(title);
        article.setDescription(description);
        article.setPrice(price);
        article.setUser(user);
        article.setImage(image);
        article.setCategory(category);

        em.persist(article);
    }

    /**
     * Diese Methode sucht in der Datenbank nach allen Artikeln, die eine bestimmter Kategorie zugeordnet sind.
     *
     * @param category die Kategorie nach der gesucht werden soll
     *
     * @return eine Liste mit gefundenen Artikeln
     */
    public List<Article> findByCategory(Category category) {
        if (Category.contains(category)) {
            return em.createQuery("SELECT a FROM Article a WHERE a.category = :category")
                    .setParameter("category", category)
                    .getResultList();
        }

        Errors.add(UserCommunication.ERROR);
        return null;
    }

    /**
     * Diese Methode sucht in der Datenbank nach Artikeln mit einem bestimmten Titeln,
     * die einer bestimmten Kategorie zugeordnet sind.
     *
     * @param title der Titel nach dem gesucht werden soll
     * @param category die Kategorie nach der gesucht werden soll
     *
     * @return eine Liste mit gefundenen Artikeln
     */
    public List<Article> findByTitleAndCategory(String title, Category category) {
        if (Category.contains(category)) {
            return em.createQuery("SELECT a FROM Article a WHERE a.title LIKE :title AND a.category = :category")
                    .setParameter("title", title)
                    .setParameter("category", category)
                    .getResultList();
        }
        Errors.add(UserCommunication.ERROR);
        return null;
    }
}
