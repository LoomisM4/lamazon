package dhbw.lamazon.servlets;

import dhbw.lamazon.beans.UserBean;
import dhbw.lamazon.entities.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Marcel Wettach
 */
@WebServlet(urlPatterns = {
        "/registrieren"
})
public class RegistrierenServlet extends HttpServlet {
    @EJB
    private UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Evtl. vorhandene Fehler und Nachrichten aus der Session löschen
        HttpSession session = request.getSession();
        session.removeAttribute("errors");
        session.removeAttribute("message");

        new Dispatcher(request, response).navigateTo("registrieren.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Error aus der Session löschen
        request.removeAttribute("errors");

        String username = request.getParameter("benutzername");
        String email = request.getParameter("email");
        String passwort1 = request.getParameter("passwort1");
        String passwort2 = request.getParameter("passwort2");
        String vorname = request.getParameter("vorname");
        String nachname = request.getParameter("nachname");
        String strasse = request.getParameter("strasse");
        String hausnummer = request.getParameter("hausnummer");
        String plzString = request.getParameter("plz");
        String ort = request.getParameter("ort");
        String agb = request.getParameter("agb");

        List<String> errors = new ArrayList<>();

        // Validierung
        if (username.length() == 0 ||
                email.length() == 0 ||
                passwort1.length() == 0 ||
                passwort2.length() == 0 ||
                vorname.length() == 0 ||
                nachname.length() == 0 ||
                strasse.length() == 0 ||
                hausnummer.length() == 0 ||
                plzString.length() == 0 ||
                ort.length() == 0) {
            errors.add("Bitte füllen Sie alle Felder aus");
        }

        if (!passwort1.equals(passwort2)) {
            errors.add("Die beiden Passwörter müssen übereinstimmen");
        }

        if (agb == null) {
            errors.add("Bitte akzeptieren sie die AGB");
        }

        long plz = 0;
        try {
            plz = Long.valueOf(plzString);
        } catch (NumberFormatException e) {
            errors.add("Geben Sie eine korrekte Postleitzahl an");
        }

        Dispatcher d = new Dispatcher(request, response);

        // Falls Fehler vorhanden sind, werden diese im Request gespeichert und die Seite neugeladen
        if (!errors.isEmpty()) {
            request.setAttribute("errors", errors);
            d.navigateTo("registrieren.jsp");
        }
        // Falls keine Fehler vorhanden sind, wird ein neuer Benutzer angelegt
        else {
            User user = userBean.register(username, email, passwort1, vorname, nachname, strasse, hausnummer, plz, ort);
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                session.setAttribute("message", "Ihr Konto wurde erfolgreich angelegt");
                d.navigateTo("startseite.jsp");
            } else {
                List<String> beanErrors = userBean.getErrors();
                errors.addAll(beanErrors);
                request.setAttribute("errors", errors);
                d.navigateTo("registrieren.jsp");
            }
        }
    }
}
