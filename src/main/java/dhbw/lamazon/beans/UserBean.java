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

/**
 * liefert die Fachlogik für User-Objekte
 */
@Stateless
public class UserBean {
    @PersistenceContext
    EntityManager em;
    @Getter
    List<String> errors = new ArrayList<>();

    /**
     * gleicht die übergebenen Daten mit den in der Datenbank gespeicherten Werten ab
     * und liefert, falls diese Kombination vorhanden ist ein User-Objekt zurück
     *
     * @param email die E-Mail-Adresse mit der sich ein Benutzer einloggen möchte
     * @param password das Passwort, mit dem sich ein Benutzer einloggen möchte
     *
     * @return Falls der Login erfolgreich war, wird ein User-Objekt zurückgegeben.
     * Dieses muss anschließend in der Session gespeichert werden.
     * Falls die Kombination aus E-Mail-Adresse und Passwort nicht bekannt ist,
     * wird null zurückgegeben. In diesem Fall können Fehler über die Methode getErrors()
     * ermittelt werden.
     */
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

    /**
     * Erstellt einen neuen User und speichert diesen in der Datenbank.
     * Das Passwort wird hierbei Verschlüsselt in der Datenbank abgelegt
     * (das Hashing erfolgt automatisch).
     *
     * @param username der Benutzername des neuen Users
     * @param email die E-Mail-Adresse des neuen Users
     * @param password das Password des neuen Users
     * @param vorname der Vorname des neuen Users
     * @param nachname der Nachname des neuen Users
     * @param strasse die Straße inkl. der Hausnummer des neuen Users
     * @param plz die Postleitzahl des neuen Users
     * @param ort der Ort des neuen Users
     *
     * @return Falls es beim Speichern keine Fehler gab, wird das neue User-Objekt zurückgegeben.
     * Dieses muss anschließend noch in der Session gespeichert werden.
     * Falls Fehler aufgetreten sind, können diese mit der Methode getErrors() ermittelt werden.
     */
    public User register(String username, String email, String password, String vorname, String nachname, String strasse, long plz, String ort) {
        User u = new User();
        // Passwort hashen
        password = DigestUtils.sha256Hex(password);
        // User speichern
        u.setBenutzername(username);
        u.setEmail(email);
        u.setPasswort(password);
        u.setVorname(vorname);
        u.setNachname(nachname);
        u.setStrasse(strasse);
        u.setPlz(plz);
        u.setOrt(ort);

        // TODO profen, ob bereits ein Konto zurE-Mail Adresse besteht
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
