package dhbw.lamazon.servlets;

import dhbw.lamazon.Errors;
import dhbw.lamazon.Messages;
import dhbw.lamazon.SecurityCheck;
import dhbw.lamazon.beans.ArticleBean;
import dhbw.lamazon.entities.User;
import dhbw.lamazon.enums.Category;
import dhbw.lamazon.enums.UserCommunication;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Marcel Wettach
 */
@WebServlet(urlPatterns = {
        "/neuerartikel"
})
public class NeuerArtikelServlet extends HttpServlet {
    @EJB
    ArticleBean articelBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (SecurityCheck.isUserLoggedIn(request, response)) {
            new Dispatcher(request, response).navigateTo("neuerArtikel.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<FileItem> items = this.ProcessRequest(request);
        List<String> values = new ArrayList<>();
        byte[] image = null;
        for (FileItem item : items) {
            if (item.isFormField()) {
                values.add(item.getString());
            } else {
                long size = item.getSize();
                if (size <= 4096000) {
                    image = item.get();
                } else {
                    Errors.add(UserCommunication.IMAGE_TOO_BIG);
                }
            }
        }

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        double preis = 0;
        try {
            preis = Double.valueOf(values.get(3));
        } catch (NumberFormatException e) {
            Errors.add(UserCommunication.PRICE_WRONG);
        }

        if (Errors.isEmpty()) {
            articelBean.createNewArticle(values.get(0), values.get(1), preis, user, image, Category.getCategory(values.get(2)));
            Messages.add(UserCommunication.ARTICLE_PUBLISHED);
            response.sendRedirect("/startseite");
        } else {
            response.sendRedirect("/neuerartikel");
        }
    }

    private List<FileItem> ProcessRequest(HttpServletRequest request) {
        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Configure a repository (to ensure a secure temp location is used)
        ServletContext servletContext = this.getServletConfig().getServletContext();
        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(repository);

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        List<FileItem> fileItems = null;

        // Parse the request
        try {
            fileItems = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        return fileItems;
    }
}
