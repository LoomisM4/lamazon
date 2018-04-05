package dhbw.lamazon.servlets;

import dhbw.lamazon.Errors;
import dhbw.lamazon.Messages;
import dhbw.lamazon.SecurityCheck;
import dhbw.lamazon.beans.ArticleBean;
import dhbw.lamazon.entities.Article;
import dhbw.lamazon.enums.UserCommunication;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Marcel Wettach
 */
@WebServlet(urlPatterns = {
        "/artikelentfernen"
})
public class ArtikelEntfernenServlet extends HttpServlet {
    @EJB
    private ArticleBean articleBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idString = request.getParameter("id");
        long id = 0;
        Article article = null;
        try {
            id = Long.valueOf(idString);
            article = articleBean.findArticleById(id);
        } catch (NumberFormatException e) {
            Errors.add(UserCommunication.ERROR);
        }

        if (Errors.isEmpty() &&
                article != null &&
                SecurityCheck.isUserLoggedIn(request, response) &&
                SecurityCheck.isUserOwnerOfProduct(request, response, article)) {
            articleBean.deleteArticle(article);
            Messages.add(UserCommunication.ARTICLE_DELETED);
        }

        response.sendRedirect("/meinkonto");
    }
}
