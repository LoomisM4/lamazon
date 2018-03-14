package dhbw.lamazon.servlets;

import dhbw.lamazon.Errors;
import dhbw.lamazon.Messages;

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
        "/partner"
})
public class PartnerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Evtl. vorhandene Fehler und Nachrichten löschen
        Errors.clear();
        Messages.clear();

        new Dispatcher(request, response).navigateTo("partner.jsp");
    }
}
