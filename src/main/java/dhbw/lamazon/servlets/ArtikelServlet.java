package dhbw.lamazon.servlets;

import dhbw.lamazon.Errors;
import dhbw.lamazon.Messages;
import dhbw.lamazon.beans.ArticleBean;
import dhbw.lamazon.entities.Article;

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
        "/artikel"
})
public class ArtikelServlet extends HttpServlet {
    @EJB
    private ArticleBean articleBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Evtl. vorhandene Fehler und Nachrichten löschen
        Errors.clear();
        Messages.clear();

        HttpSession session = request.getSession();
        Dispatcher d = new Dispatcher(request, response);

        String idText = request.getParameter("id");
        long id = 0;
        try {
            id = Long.valueOf(idText);

            Article article = articleBean.findArticleById(id);
            if (article == null) {
                Errors.add("Der gesuchte Artikel wurde nicht gefunden");
            } else {
                session.setAttribute("article", article);
            }
        } catch (NumberFormatException e) {
            Errors.add("Da ist etwas schiefgelaufen");
        }

        d.navigateTo("artikel.jsp");
    }
}
