package dhbw.lamazon.servlets;

import dhbw.lamazon.beans.ArticleBean;
import dhbw.lamazon.beans.UserBean;
import dhbw.lamazon.entities.Article;
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
        "/meinkonto"
})
public class MeinKontoServlet extends HttpServlet {
    @EJB
    private UserBean userBean;
    @EJB
    private ArticleBean articleBean;

    private List<String> errors = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Evtl. vorhandene Fehler und Nachrichten aus der Session löschen
        HttpSession session = request.getSession();
        session.removeAttribute("errors");
        session.removeAttribute("message");
        this.errors.clear();

        Dispatcher d = new Dispatcher(request, response);
        User user = (User) session.getAttribute("user");

        // falls kein User eingeloggt ist, wird automatisch die Seite zum Einloggen angezeigt
        if (user == null) {
            session.setAttribute("errors", new ArrayList<String>().add("Sie müssen eingeloggt sein, um diesen Bereich zu betreten"));

            d.navigateTo("anmelden.jsp");
        } else {
            // alle vom Nutzer eingestellten Artikel werden eingelesen und im Request gespeichert
            List<Article> articles = articleBean.findArticlesByUser(user);
            request.setAttribute("articles", articles);

            d.navigateTo("meinKonto.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Errors und Nachrichten aus der Session löschen
        request.removeAttribute("errors");
        request.removeAttribute("message");

        HttpSession session = request.getSession();

        String vorname = request.getParameter("vorname");
        String nachname = request.getParameter("nachname");
        String strasse = request.getParameter("strasse");
        String hausnr = request.getParameter("hausnr");
        String plzString = request.getParameter("plz");
        String ort = request.getParameter("ort");
        String benutzername = request.getParameter("benutzername");
        String email = request.getParameter("email");
        String passwort = request.getParameter("passwort");
        User user = (User) session.getAttribute("user");

        if (vorname.length() == 0 ||
                nachname.length() == 0 ||
                strasse.length() == 0 ||
                hausnr.length() == 0 ||
                plzString.length() == 0 ||
                ort.length() == 0 ||
                benutzername.length() == 0 ||
                email.length() == 0 ||
                passwort.length() == 0) {
            this.errors.add("Bitte füllen Sie alle Felder aus, wenn Sie Daten ändern wollen");
        }

        long plz = 0;
        try {
            plz = Long.valueOf(plzString);
        } catch (NumberFormatException e) {
            this.errors.add("Geben Sie eine gültige PLZ an");
        }

        if (errors.isEmpty()) {
            userBean.changeData(user, benutzername, email, passwort, vorname, nachname, strasse, hausnr, plz, ort);
            request.setAttribute("message", new String("Ihre Daten wurden erfolgreich geändert"));
        } else {
            request.setAttribute("errors", errors);
        }

        new Dispatcher(request, response).navigateTo("meinKonto.jsp");
    }
}
