package dhbw.lamazon.beans;

import dhbw.lamazon.entities.Message;
import dhbw.lamazon.entities.User;

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

    /**
     * sucht in der Datenbank nach der Nachricht mit der angegebenen ID und löscht diese aus der Datenabnk
     *
     * @param id die ID der Nachricht, die gelöscht werden soll
     */
    public synchronized void deleteMessageById(long id) {
        this.deleteMessage(this.findMessageById(id));
    }

    /**
     * Löscht die übergebende Nachricht aus der Datenbank
     *
     * @param message die Nachricht, die gelöscht werden soll
     */
    public synchronized void deleteMessage(Message message) {
        User receiver = message.getReceiver();
        receiver.getReceivedMessages().remove(message);
        em.merge(receiver);
        em.remove(message);
    }
}
