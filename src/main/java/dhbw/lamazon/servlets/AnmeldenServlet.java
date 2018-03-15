package dhbw.lamazon.servlets;

import dhbw.lamazon.Errors;
import dhbw.lamazon.beans.UserBean;
import dhbw.lamazon.entities.User;

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
        "/anmelden"
})
public class AnmeldenServlet extends HttpServlet {
    @EJB
    private UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        new Dispatcher(request, response).navigateTo("anmelden.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("passwort");

        HttpSession session = request.getSession();
        Dispatcher d = new Dispatcher(request, response);

        if (email.length() == 0 ||
                password.length() == 0) {
            Errors.add("Bitte füllen Sie alle Felder aus");
        } else {
            User user = userBean.login(email, password);

            if (user != null) {
                session.setAttribute("user", user);
                d.navigateTo("startseite.jsp");
            }
        }

        if (!Errors.isEmpty()) {
            d.navigateTo("anmelden.jsp");
        }
    }
}
