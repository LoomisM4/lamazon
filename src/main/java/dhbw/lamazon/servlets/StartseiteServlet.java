package dhbw.lamazon.servlets;

import dhbw.lamazon.beans.ArticleBean;
import dhbw.lamazon.entities.Article;
import dhbw.lamazon.enums.Category;

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
        "/lamazon",
        "/startseite"
})
public class StartseiteServlet extends HttpServlet {
    @EJB
    private ArticleBean articleBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        List<Article> articles = articleBean.findAllArticles();
        session.setAttribute("articles", articles);
        session.setAttribute("categories", Category.values());

        new Dispatcher(request, response).navigateTo("startseite.jsp");
    }
}
