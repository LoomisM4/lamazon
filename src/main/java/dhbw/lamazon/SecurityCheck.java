package dhbw.lamazon;

import dhbw.lamazon.entities.User;
import dhbw.lamazon.enums.UserCommunication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Die Klasse überprüft verschiedene Sicherheitsrichtlinien.
 * Ihre Methoden können statisch verwendet werden.
 *
 * @author Marcel Wettach
 */
public class SecurityCheck {

    /**
     * Überprüft, ob ein Benutzer angemeldet ist.
     * Ist dies nicht der Fall, erfolgt automatisch eine Weiterleitung auf die Seite zum Einloggen und
     * ein Fehler wird ausgegeben.
     *
     * @param request das Request-Objekt des Servlets
     * @param response das Response-Objekt des Servlets
     *
     * @return true, wenn ein Benutzer eingeloggt ist.
     * false, wenn kein Benutzer eingeloggt ist. In diesem Fall erfolgt automatisch ein Redirect.
     *
     * @throws IOException
     */
    public static boolean isUserLoggedIn(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Object o = session.getAttribute("user");
        if (o == null || o.getClass() != User.class) {
            Errors.add(UserCommunication.LOGIN_REQUIRED);
            response.sendRedirect("/anmelden");
            return false;
        }
        return true;
    }

    /**
     * Überprüft, ob der eingeloggte Benutzer (ob dies der fall ist, muss separat überprüft werden) entweder der
     * Versender oder der Empfänger der Nachricht ist, die geöffnet werden soll.
     * Ist dies nicht der Fall, erfolgt automatisch eine Weiterleitung auf die Seite zum Einloggen und
     * ein Fehler wird ausgegeben.
     *
     * @param request das Request-Objekt des Servlets
     * @param response das Response-Objekt des Servlets
     *
     * @return true, wenn der Benutzer das Recht hat die Nachricht zu lesen.
     * false, wenn der Benutzer dieses Recht nicht hat. In diesem Fall erfolgt automatisch ein Redirect.
     *
     * @throws IOException
     */
    public static boolean isUserAllowedToViewMessage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String idText = request.getParameter("id");
        long id = 0;
        try {
            id = Long.valueOf(idText);
        } catch (NumberFormatException e) {
            Errors.add(UserCommunication.ERROR);
        }

        long finalId = id;
        AtomicBoolean isAvailable = new AtomicBoolean(false);
        user.getReceivedMessages().forEach(message -> {
            if (message.getId() == finalId) {
                isAvailable.set(true);
            }
        });
        if (isAvailable.get() == false) {
            user.getSendMessages().forEach(message -> {
                if (message.getId() == finalId) {
                    isAvailable.set(true);
                }
            });
        }
        if (isAvailable.get())
            return true;

        Errors.add(UserCommunication.NO_RIGHTS);
        response.sendRedirect("/lamazon");
        return false;
    }
}
