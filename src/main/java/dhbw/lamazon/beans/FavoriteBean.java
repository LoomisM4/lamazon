package dhbw.lamazon.beans;

import dhbw.lamazon.entities.Favorite;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Marcel Wettach
 */
@Stateless
public class FavoriteBean {
    @PersistenceContext
    private EntityManager em;

    /**
     * Sucht in der Datenbank nach einem Favoriten mit der übergebenen ID
     *
     * @param id die ID nach der gesucht werden soll
     *
     * @return ein Favorite-Objekt, falls ein passender Eintrag in der Datenbank gefunden wurde.
     */
    public synchronized Favorite findFavoriteById(long id) {
        return em.find(Favorite.class, id);
    }
}
