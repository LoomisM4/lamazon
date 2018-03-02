package dhbw.lamazon.servlets;

import dhbw.lamazon.beans.BenutzerBean;
import dhbw.lamazon.entities.Benutzer;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {
        "/anmelden"
})
public class AnmeldenServlet extends HttpServlet {
    @EJB
    BenutzerBean userBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        new Dispatcher(request, response).navigateTo("anmelden.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("benutzername");
        String password = request.getParameter("passwort");

        HttpSession session = request.getSession();

        // TODO Eingaben prüfen und Fehler zeigen

        Benutzer user = userBean.login(username, password);

        if (user == null) {
            // TODO Logindaten wahrscheinlich falsch
        } else {
            session.setAttribute("user", user);
            new Dispatcher(request, response).navigateTo("startseite.jsp");
        }
    }
}
