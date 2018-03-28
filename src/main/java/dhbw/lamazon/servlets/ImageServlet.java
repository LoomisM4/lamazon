package dhbw.lamazon.servlets;

import dhbw.lamazon.Errors;
import dhbw.lamazon.beans.ArticleBean;
import dhbw.lamazon.entities.Article;
import dhbw.lamazon.enums.UserCommunication;

import javax.ejb.EJB;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Marcel Wettach
 */
@WebServlet(urlPatterns = {
        "/image"
})
public class ImageServlet extends HttpServlet {
    @EJB
    ArticleBean articleBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/png");

        List<Article> articles = (List<Article>) request.getSession().getAttribute("articles");

        String idText = request.getParameter("articleId");
        long id = 0;
        try {
            id = Long.valueOf(idText);
        } catch (NumberFormatException e) {
            Errors.add(UserCommunication.ERROR);
            response.sendRedirect("/lamazon");
        }

        long finalId = id;
        Optional<Article> article = articles.stream().filter(a -> a.getId() == finalId).findFirst();

        AtomicReference<BufferedImage> image = new AtomicReference<>();
        article.ifPresent(a -> image.set(a.getImage()));

        if (image.get() != null)
            ImageIO.write(image.get(), "png", response.getOutputStream());
        else {
            BufferedImage img = ImageIO.read(new URL(Dispatcher.baseUrl.replace("lamazon", "img/Standardbild.jpg")));
            ImageIO.write(img, "png", response.getOutputStream());
        }
    }
}
