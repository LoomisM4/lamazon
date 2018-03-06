package dhbw.lamazon.beans;

import dhbw.lamazon.entities.User;
import lombok.Getter;
import org.apache.commons.codec.digest.DigestUtils;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class UserBean {
    @PersistenceContext
    EntityManager em;
    @Getter
    List<String> errors = new ArrayList<>();

    public User login(String email, String password) {
        User user = null;
        // Hashing
        password = DigestUtils.sha256Hex(password);
        try {
            user = (User) em.createQuery("SELECT u FROM User u WHERE u.email = :email AND u.passwort = :passwort")
                    .setParameter("email", email)
                    .setParameter("passwort", password)
                    .getSingleResult();
        } catch (NoResultException e) {
            errors.add("E-Mail-Adresse oder Passwort falsch");
        }
        return user;
    }

    public User register(String username, String email, String password) {
        User u = new User();
        // Passwort hashen
        password = DigestUtils.sha256Hex(password);
        // User speichern
        u.setBenutzername(username);
        u.setEmail(email);
        u.setPasswort(password);

        // TODO profen, ob bereits ein KOnto zurE-Mail Adresse besteht
        Object o = null;
        try {
            o = em.createQuery("SELECT u FROM User u WHERE u.email = :email")
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            // TODO evtl kann das verbesert werden -> hier E-Mail noch nicht vorhanden
        }

        if (o != null) {
            errors.add("Zu jeder E-Mail-Adresse darf nur ein Konto vorhanden sein");
            return null;
        } else {
            em.persist(u);
            return em.merge(u);
        }
    }
}
