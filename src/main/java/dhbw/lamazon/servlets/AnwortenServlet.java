package dhbw.lamazon.servlets;

import dhbw.lamazon.Errors;
import dhbw.lamazon.beans.MessageBean;
import dhbw.lamazon.entities.Article;
import dhbw.lamazon.entities.Message;
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
        "/antworten"
})
public class AnwortenServlet extends HttpServlet {
    @EJB
    private MessageBean messageBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idString = request.getParameter("id");
        HttpSession session = request.getSession();

        long id = 0;
        try {
            id = Long.valueOf(idString);
            Message message = messageBean.findMessageById(id);
            Article article = new Article();
            article.setUser(message.getSender());
            session.setAttribute("article", article);
            response.sendRedirect("/neuenachricht");
        } catch (NumberFormatException e) {
            Errors.add(UserCommunication.ERROR);
            response.sendRedirect("/lamazon");
        }
    }
}
