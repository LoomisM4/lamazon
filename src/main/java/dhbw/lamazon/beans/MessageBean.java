package dhbw.lamazon.beans;

import dhbw.lamazon.entities.Message;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * liefert die Fachlogik für Message-Objekte
 *
 * @author Marcel Wettach
 */
@Stateless
public class MessageBean {
    @PersistenceContext
    EntityManager em;

    /**
     * sucht anhand der übergeben ID nach einer Nachricht und gibt diese zurück
     *
     * @param id die ID der zu suchenden Nachricht
     *
     * @return ein Message-Objekt, falls eine Nachricht gefunden wurde.
     * null, falls keine Nachricht gefunden wurde.
     */
    public synchronized Message findMessageById(long id) {
        return em.find(Message.class, id);
    }
}
