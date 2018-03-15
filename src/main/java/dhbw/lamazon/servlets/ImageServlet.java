package dhbw.lamazon.servlets;

import dhbw.lamazon.Errors;
import dhbw.lamazon.beans.ArticleBean;
import dhbw.lamazon.entities.Article;

import javax.ejb.EJB;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

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

        String idText = request.getParameter("articleId");
        long id = 0;
        try {
            id = Long.valueOf(idText);
        } catch (NumberFormatException e) {
            Errors.add("Das ist etwas schiefgelaufen");
            // TODO irgendwohin weiterleiten
        }

        Article article = articleBean.findArticleById(id);
        BufferedImage image = article.getImage();

        if (image != null)
            ImageIO.write(image, "png", response.getOutputStream());
    }
}
