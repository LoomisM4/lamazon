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
import java.io.IOException;
import java.util.List;

/**
 * @author Marcel Wettach
 */
@WebServlet(urlPatterns = {
        "/suchen"
})
public class SuchenServlet extends HttpServlet {
    @EJB
    private ArticleBean articleBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("suchen");
        String categoryString = request.getParameter("kategorie");
        Category category = Category.getCategory(categoryString);

        List<Article> articles = null;

        if (search.length() == 0 && category.equals(Category.ALLE)) {
            articles = articleBean.findAllArticles();
        } else if (category.equals(Category.ALLE)) {
            articles = articleBean.findArticleByTitle(search);
        } else if (!category.equals(Category.ALLE) && search.length() == 0) {
            articles = articleBean.findByCategory(category);
        } else {
            articles = articleBean.findByTitleAndCategory(search, category);
        }

        request.setAttribute("articles", articles);

        new Dispatcher(request, response).navigateTo("suchergebnis.jsp");
    }
}
