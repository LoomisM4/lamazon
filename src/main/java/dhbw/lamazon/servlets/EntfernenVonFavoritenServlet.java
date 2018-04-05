package dhbw.lamazon.servlets;

import dhbw.lamazon.Errors;
import dhbw.lamazon.Messages;
import dhbw.lamazon.SecurityCheck;
import dhbw.lamazon.beans.FavoriteBean;
import dhbw.lamazon.beans.UserBean;
import dhbw.lamazon.entities.Favorite;
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

/**
 * @author Marcel Wettach
 */
@WebServlet(urlPatterns = {
        "/entfernenvonfavoriten"
})
public class EntfernenVonFavoritenServlet extends HttpServlet {
    @EJB
    private UserBean userBean;
    @EJB
    private FavoriteBean favoriteBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idString = request.getParameter("id");
        long id = 0;
        try {
            id = Long.valueOf(idString);
        } catch (NumberFormatException e) {
            Errors.add(UserCommunication.ERROR);
        }
        if (!SecurityCheck.isUserLoggedIn(request, response)) {
            Errors.add(UserCommunication.LOGIN_REQUIRED);
            response.sendRedirect("/anmelden");
        }

        if (Errors.isEmpty()) {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            Favorite favorite = favoriteBean.findFavoriteById(id);
            userBean.deleteFromFavorites(user, favorite);
            Messages.add(UserCommunication.ARTICLE_DELETED);
        }

        response.sendRedirect("/favoriten");
    }
}
