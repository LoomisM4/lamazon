package dhbw.lamazon.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {
        "/abmelden"
})
public class AbmeldenServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Evtl. vorhandene Fehler und Nachrichten aus der Session löschen
        HttpSession session = request.getSession();
        session.removeAttribute("errors");
        session.removeAttribute("message");
        // Den User aus der Session löschen
        session.removeAttribute("user");
        request.setAttribute("message", "Sie wurden erfolgreich ausgeloggt");

        new Dispatcher(request, response).navigateTo("startseite.jsp");
    }
}
