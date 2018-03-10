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
 *
 * @author Marcel Wettach
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
        this.errors.clear();

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
            return null;
        }
        return user;
    }

    /**
     * Erstellt einen neuen User und speichert diesen in der Datenbank.
     * Das Passwort wird hierbei verschlüsselt in der Datenbank abgelegt
     * (das Hashing erfolgt automatisch).
     *
     * @param username der Benutzername des neuen Users
     * @param email die E-Mail-Adresse des neuen Users
     * @param password das Password des neuen Users
     * @param vorname der Vorname des neuen Users
     * @param nachname der Nachname des neuen Users
     * @param strasse die Straße des neuen Users
     * @param hausnr die Hausnummer des neuen Users
     * @param plz die Postleitzahl des neuen Users
     * @param ort der Ort des neuen Users
     *
     * @return Falls es beim Speichern keine Fehler gab, wird das neue User-Objekt zurückgegeben.
     * Dieses muss anschließend noch in der Session gespeichert werden.
     * Falls Fehler aufgetreten sind, können diese mit der Methode getErrors() ermittelt werden.
     */
    public User register(String username, String email, String password, String vorname, String nachname, String strasse, String hausnr, long plz, String ort) {
        this.errors.clear();

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
        u.setHausnr(hausnr);
        u.setPlz(plz);
        u.setOrt(ort);

        try {
            Object o = em.createQuery("SELECT u FROM User u WHERE u.email = :email")
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            // Falls zu dieser E-Mail-Adresse noch kein Account vorhanden ist, wird dieser Teil ausgeführt
            em.persist(u);
            return em.merge(u);
        }
        // Falls diese E-Mail-Adresse schon vergeben ist, wird ein Fehler gespeichert
        errors.add("Zu jeder E-Mail-Adresse darf nur ein Konto vorhanden sein");
        return null;
    }

    /**
     * diese Methode ändert die Daten eines User-Objektes und speichert die Veränderungen in der Datenbank
     *
     * @param user das User-Objekt, das verändert werden soll
     * @param newUsername der neue Benutzername
     * @param newEmail die neue E-Mail-Adresse
     * @param newPassword das neue Passwort
     * @param newVorname der neue Vorname
     * @param newNachname der neue Nachname
     * @param newStrasse die neue Strasse
     * @param newHausnr die neue Hausnummer
     * @param newPlz die neue Postleitzahl
     * @param newOrt der neue Wohnort
     *
     * @return das neue, veränderte User-Objekt
     */
    public User changeData(User user, String newUsername, String newEmail, String newPassword, String newVorname, String newNachname, String newStrasse, String newHausnr, long newPlz, String newOrt) {
        user.setBenutzername(newUsername);
        user.setEmail(newEmail);
        user.setPasswort(DigestUtils.sha256Hex(newPassword));
        user.setVorname(newVorname);
        user.setNachname(newNachname);
        user.setStrasse(newStrasse);
        user.setHausnr(newHausnr);
        user.setPlz(newPlz);
        user.setOrt(newOrt);

        return em.merge(user);
    }
}
