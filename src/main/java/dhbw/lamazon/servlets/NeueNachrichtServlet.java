package dhbw.lamazon.servlets;

import dhbw.lamazon.Messages;
import dhbw.lamazon.SecurityCheck;
import dhbw.lamazon.beans.UserBean;
import dhbw.lamazon.entities.Article;
import dhbw.lamazon.entities.User;
import dhbw.lamazon.enums.UserCommunication;

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
    UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (SecurityCheck.isUserLoggedIn(request, response) &&
                SecurityCheck.SessionHasAttributeOfType("article", Article.class, request, response)) {
            new Dispatcher(request, response).navigateTo("neueNachricht.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = request.getParameter("nachricht");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Article article = (Article) session.getAttribute("article");

        userBean.sendNewMessage(user, article.getUser(), message);

        Messages.add(UserCommunication.MESSAGE_SENT);

        response.sendRedirect("/artikel?id=" + article.getId());
    }
}
