package dhbw.lamazon.servlets;

import dhbw.lamazon.Errors;
import dhbw.lamazon.Messages;
import dhbw.lamazon.beans.MessageBean;
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

/**
 * @author Marcel Wettach
 */
@WebServlet(urlPatterns = {
        "/neuenachricht"
})
public class NeueNachrichtServlet extends HttpServlet {
    @EJB
    MessageBean messageBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Evtl. vorhandene Fehler und Nachrichten löschen
        Errors.clear();
        Messages.clear();

        HttpSession session = request.getSession();
        Object o = session.getAttribute("user");
        if (o == null) {
            Errors.add("Sie müssen eingeloggt sein, um diesen Bereich zu betreten");
            response.sendRedirect("/anmelden");
        } else {
            new Dispatcher(request, response).navigateTo("neueNachricht.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = request.getParameter("nachricht");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Article article = (Article) session.getAttribute("article");

        messageBean.sendNewMessage(user, article.getUser(), message);

        Messages.add("Nachricht wurde versandt");

        new Dispatcher(request, response).navigateTo("artikel.jsp");
    }
}
