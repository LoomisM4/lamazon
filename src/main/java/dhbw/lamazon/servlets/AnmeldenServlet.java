package dhbw.lamazon.servlets;

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
import java.util.ArrayList;
import java.util.List;

/**
 * @author Marcel Wettach
 */
@WebServlet(urlPatterns = {
        "/anmelden"
})
public class AnmeldenServlet extends HttpServlet {
    @EJB
    private UserBean userBean;
    private List<String> errors = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Evtl. vorhandene Fehler und Nachrichten aus der Session löschen
        HttpSession session = request.getSession();
        session.removeAttribute("errors");
        session.removeAttribute("message");

        new Dispatcher(request, response).navigateTo("anmelden.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Error-Liste leeren
        this.errors.clear();

        String email = request.getParameter("email");
        String password = request.getParameter("passwort");

        HttpSession session = request.getSession();
        Dispatcher d = new Dispatcher(request, response);

        if (email.length() == 0 ||
                password.length() == 0) {
            errors.add("Bitte füllen Sie alle Felder aus");
        } else {
            User user = userBean.login(email, password);

            if (user == null) {
                List<String> beanErrors = userBean.getErrors();
                errors.addAll(beanErrors);
            } else {
                session.setAttribute("user", user);
                d.navigateTo("startseite.jsp");
            }
        }

        if (!errors.isEmpty()) {
            request.setAttribute("errors", errors);
            d.navigateTo("anmelden.jsp");
        }
    }
}
