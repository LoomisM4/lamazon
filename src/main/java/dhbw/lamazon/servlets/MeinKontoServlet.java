package dhbw.lamazon.servlets;

import dhbw.lamazon.Errors;
import dhbw.lamazon.Messages;
import dhbw.lamazon.SecurityCheck;
import dhbw.lamazon.beans.ArticleBean;
import dhbw.lamazon.beans.UserBean;
import dhbw.lamazon.entities.Article;
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
import java.util.List;

/**
 * @author Marcel Wettach
 */
@WebServlet(urlPatterns = {
        "/meinkonto"
})
public class MeinKontoServlet extends HttpServlet {
    @EJB
    private UserBean userBean;
    @EJB
    private ArticleBean articleBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Object o = session.getAttribute("user");

        if (SecurityCheck.isUserLoggedIn(request, response)) {
            // alle vom Nutzer eingestellten Artikel werden eingelesen und im Request gespeichert
            List<Article> articles = articleBean.findArticlesByUser((User) o);
            request.setAttribute("articles", articles);

            new Dispatcher(request, response).navigateTo("meinKonto.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String vorname = request.getParameter("vorname");
        String nachname = request.getParameter("nachname");
        String strasse = request.getParameter("strasse");
        String hausnr = request.getParameter("hausnr");
        String plzString = request.getParameter("plz");
        String ort = request.getParameter("ort");
        String email = request.getParameter("email");
        String passwort = request.getParameter("passwort");
        User user = (User) session.getAttribute("user");

        if (vorname.length() == 0 ||
                nachname.length() == 0 ||
                strasse.length() == 0 ||
                hausnr.length() == 0 ||
                plzString.length() == 0 ||
                ort.length() == 0 ||
                email.length() == 0 ||
                passwort.length() == 0) {
            Errors.add(UserCommunication.MISSING_FIELDS);
        }

        long plz = 0;
        try {
            plz = Long.valueOf(plzString);
        } catch (NumberFormatException e) {
            Errors.add(UserCommunication.WRONG_ZIP_CODE);
        }

        if (Errors.isEmpty()) {
            userBean.changeData(user, user.getBenutzername(), email, passwort, vorname, nachname, strasse, hausnr, plz, ort);
            Messages.add(UserCommunication.CHANGES_SUCCESSFUL);
        }

        new Dispatcher(request, response).navigateTo("meinKonto.jsp");
    }
}
