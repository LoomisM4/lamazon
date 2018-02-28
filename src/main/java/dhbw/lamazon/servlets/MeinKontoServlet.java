package dhbw.lamazon.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {
        "/meinkonto"
})
public class MeinKontoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Dispatcher d = new Dispatcher(request, response);

        // falls kein Benutzer eingeloggt ist, wird automatisch die Seite zum EInloggen angezeigt
        if (session.getAttribute("user") == null) {
            d.navigateTo("anmelden.jsp");
        } else {
            d.navigateTo("meinKonto.jsp");
        }
    }
}
