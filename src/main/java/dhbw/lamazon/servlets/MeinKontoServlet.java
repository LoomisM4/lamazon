package dhbw.lamazon.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {
        "/meinkonto"
})
public class MeinKontoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Evtl. vorhandene Fehler und Nachrichten aus der Session löschen
        HttpSession session = request.getSession();
        session.removeAttribute("errors");
        session.removeAttribute("message");

        Dispatcher d = new Dispatcher(request, response);

        // falls kein User eingeloggt ist, wird automatisch die Seite zum Einloggen angezeigt
        if (session.getAttribute("user") == null) {
            session.setAttribute("errors", new ArrayList<String>().add("Sie müssen eingeloggt sein, um diesen Bereich zu betreten"));
            d.navigateTo("anmelden.jsp");
        } else {
            d.navigateTo("meinKonto.jsp");
        }
    }
}
