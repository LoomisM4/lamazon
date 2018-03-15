package dhbw.lamazon.servlets;

import dhbw.lamazon.Errors;
import dhbw.lamazon.beans.MessageBean;
import dhbw.lamazon.entities.Message;

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
        "/nachricht"
})
public class NachrichtServlet extends HttpServlet {
    @EJB
    private MessageBean messageBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        // TODO prüfen ob der aktuelle Benutzer die Nachricht überhaupt ansehen darf
        if (session.getAttribute("user") == null) {
            Errors.add("Sie müssen eingeloggt sein, um diesen Bereich zu betreten");
            response.sendRedirect("/anmelden");
        } else {
            String idText = request.getParameter("id");
            long id = 0;
            try {
                id = Long.valueOf(idText);
            } catch (NumberFormatException e) {
                Errors.add("Da ist etwas schiefgelaufen");
            }
            Message message = messageBean.findMessageById(id);
            request.setAttribute("message", message);
            new Dispatcher(request, response).navigateTo("nachricht.jsp");
        }
    }
}
