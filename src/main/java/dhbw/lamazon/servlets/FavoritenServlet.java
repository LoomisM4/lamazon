package dhbw.lamazon.servlets;

import dhbw.lamazon.Errors;
import dhbw.lamazon.SecurityCheck;
import dhbw.lamazon.beans.UserBean;
import dhbw.lamazon.enums.UserCommunication;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Marcel Wettach
 */
@WebServlet(urlPatterns = {
        "/favoriten"
})
public class FavoritenServlet extends HttpServlet {
    @EJB
    UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (SecurityCheck.isUserLoggedIn(request, response))
            new Dispatcher(request, response).navigateTo("favoriten.jsp");
        else {
            Errors.add(UserCommunication.LOGIN_REQUIRED);
            response.sendRedirect("/anmelden");
        }
    }
}
