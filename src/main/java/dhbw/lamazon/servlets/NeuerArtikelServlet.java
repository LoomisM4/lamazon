package dhbw.lamazon.servlets;

import dhbw.lamazon.Errors;
import dhbw.lamazon.Messages;
import dhbw.lamazon.beans.ArticleBean;
import dhbw.lamazon.entities.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Marcel Wettach
 */
@WebServlet(urlPatterns = {
        "/neuerartikel"
})
public class NeuerArtikelServlet extends HttpServlet {
    @EJB
    ArticleBean articelBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Evtl. vorhandene Fehler und Nachrichten löschen
        Errors.clear();
        Messages.clear();

        HttpSession session = request.getSession();
        Object o = session.getAttribute("user");

        if (o == null) {
            request.setAttribute("errors", new String("Sie müssen eingeloggt sein, um diesen Bereich zu betreten"));
            response.sendRedirect("/anmelden");
        } else {
            new Dispatcher(request, response).navigateTo("neuerArtikel.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bezeichnung = request.getParameter("bezeichnung");
        String beschreibung = request.getParameter("beschreibung");
        String preisText = request.getParameter("preis");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        double preis = Double.valueOf(preisText);

        articelBean.createNewArticle(bezeichnung, beschreibung, preis, user);
        request.setAttribute("message", new String("Ihr Artikel wurde erfolgreich eingestellt"));
        new Dispatcher(request, response).navigateTo("startseite.jsp");
    }
}
