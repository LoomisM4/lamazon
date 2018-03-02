package dhbw.lamazon.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {
            "/lamazon"
        })
public class StartseiteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // List<Article> articles = article.findAllArticles();
        // HttpSession session = request.getSession();
        // session.setAttribute("articles", articles);

        new Dispatcher(request, response).navigateTo("startseite.jsp");
    }
}
