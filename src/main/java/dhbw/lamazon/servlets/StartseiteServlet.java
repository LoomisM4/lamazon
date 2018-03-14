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
import java.util.List;

/**
 * @author Marcel Wettach
 */
@WebServlet(urlPatterns = {
            "/lamazon"
        })
public class StartseiteServlet extends HttpServlet {
    @EJB
    private ArticleBean articleBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Evtl. vorhandene Fehler und Nachrichten löschen
        HttpSession session = request.getSession();
        Errors.clear();
        Messages.clear();

        List<Article> articles = articleBean.getAllArticles();
        session.setAttribute("articles", articles);

        new Dispatcher(request, response).navigateTo("startseite.jsp");
    }
}
