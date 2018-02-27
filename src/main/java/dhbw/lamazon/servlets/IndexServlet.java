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
import java.util.List;

@WebServlet(urlPatterns =
        {
                "/"
        })
public class IndexServlet extends HttpServlet {
    @EJB
    ArticleBean article;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Article> articles = article.findAllArticles();
        HttpSession session = request.getSession();
        session.setAttribute("articles", articles);

        new Dispatcher(request, response).navigateTo("startseite.jsp");
    }
}
