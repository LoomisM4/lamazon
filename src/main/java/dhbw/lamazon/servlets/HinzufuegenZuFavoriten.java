package dhbw.lamazon.servlets;

import dhbw.lamazon.Errors;
import dhbw.lamazon.beans.ArticleBean;
import dhbw.lamazon.beans.UserBean;
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
        "/zufavoriten"
})
public class HinzufuegenZuFavoriten extends HttpServlet {
    @EJB
    private ArticleBean articleBean;
    @EJB
    private UserBean userBean;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String artikelString = request.getParameter("artikel");
        HttpSession session = request.getSession();
        Object o = session.getAttribute("user");

        if (o == null) {
            Errors.add(UserCommunication.LOGIN_REQUIRED);
            response.sendRedirect("/anmelden");
        } else {
            User user = (User) o;
            long articleId = 0;

            try {
                articleId = Long.valueOf(artikelString);
            } catch (NumberFormatException e) {
                Errors.add(UserCommunication.ERROR);
            }

            userBean.addToFavorites(user, articleBean.findArticleById(articleId));

            response.sendRedirect("/favoriten");
        }
    }
}
