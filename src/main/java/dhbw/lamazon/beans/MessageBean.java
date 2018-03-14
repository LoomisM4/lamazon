package dhbw.lamazon.beans;

import dhbw.lamazon.entities.Message;
import dhbw.lamazon.entities.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

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
     * erstellt eine neue Nachricht und versendet diese im Anschluss,
     * indem sie mit allen nötigen Verknüpfungen in der Datenbank gespeichert wird.
     *
     * @param sender User-Objekt des Absenders
     * @param receiver User-Objekt des Empfängers
     * @param message der Inhalt der Nachricht
     */
    public void sendNewMessage(User sender, User receiver, String message) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date = sdf.format(new Date());

        Message m = new Message();

        m.setSender(sender);
        m.setReceiver(receiver);
        m.setMessage(message);
        m.setDate(Timestamp.valueOf(date));

        em.persist(m);
    }
}