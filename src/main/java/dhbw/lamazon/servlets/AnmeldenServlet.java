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

@WebServlet(urlPatterns = {
        "/anmelden"
})
public class AnmeldenServlet extends HttpServlet {
    @EJB
    UserBean userBean;
    List<String> errors = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        new Dispatcher(request, response).navigateTo("anmelden.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Error aus der Session löschen
        request.removeAttribute("errors");

        String email = request.getParameter("email");
        String password = request.getParameter("passwort");

        HttpSession session = request.getSession();

        if (email.length() == 0 ||
                password.length() == 0) {
            errors.add("Bitte füllen Sie alle Felder aus");
        }

        // Falls ein Error vorhanden, diesen ausgeben, falls nicht login durchführen
        Dispatcher d = new Dispatcher(request, response);

        if (!errors.isEmpty()) {
            request.setAttribute("errors", errors);
            d.navigateTo("anmelden.jsp");
        }

        User user = userBean.login(email, password);

        if (user == null) {
            List<String> beanErrors = userBean.getErrors();
            beanErrors.forEach(errors::add);
        } else {
            session.setAttribute("user", user);
            new Dispatcher(request, response).navigateTo("startseite.jsp");
        }
    }
}
