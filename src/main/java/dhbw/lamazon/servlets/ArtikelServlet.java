package dhbw.lamazon.servlets;

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
import java.util.ArrayList;

@WebServlet(urlPatterns = {
        "/artikel"
})
public class ArtikelServlet extends HttpServlet {
    @EJB
    private ArticleBean articleBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Evtl. vorhandene Fehler und Nachrichten aus der Session löschen
        HttpSession session = request.getSession();
        session.removeAttribute("errors");
        session.removeAttribute("message");
        Dispatcher d = new Dispatcher(request, response);

        String idText = request.getParameter("id");
        long id = 0;
        try {
            id = Long.valueOf(idText);
        } catch (NumberFormatException e) {
            request.setAttribute("errors", new ArrayList<String>().add("Da ist etwas schiefgelaufen"));
            d.navigateTo("artikel.jsp");
        }

        Article article = articleBean.findArticleById(id);
        if (article == null) {
            request.setAttribute("errors", new ArrayList<String>().add("Der gesuchte Artikel wurde nicht gefunden"));
        } else {
            request.setAttribute("article", article);
        }

        d.navigateTo("artikel.jsp");
    }
}
