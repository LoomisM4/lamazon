package dhbw.lamazon.beans;

import dhbw.lamazon.entities.Benutzer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateless
public class BenutzerBean {
    @PersistenceContext
    EntityManager em;

    public Benutzer login(String username, String password) {
        Benutzer benutzer = null;
        try {
            benutzer = (Benutzer) em.createQuery("SELECT b FROM Benutzer b WHERE b.benutzername = :benutzername AND b.passwort = :passwort")
                    .setParameter("benutzername", username)
                    .setParameter("passwort", password)
                    .getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
        }
        return benutzer;
    }
}
