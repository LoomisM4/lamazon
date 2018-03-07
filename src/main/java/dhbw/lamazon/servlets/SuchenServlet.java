package dhbw.lamazon.servlets;

import dhbw.lamazon.beans.ArticleBean;
import dhbw.lamazon.entities.Article;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {
        "/suchen"
})
public class SuchenServlet extends HttpServlet {
    @EJB
    ArticleBean articleBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("suchen");

        List<Article> articles = articleBean.findArticleByTitle(search);
        request.setAttribute("articles", articles);

        new Dispatcher(request, response).navigateTo("suchergebnis.jsp");
    }
}
