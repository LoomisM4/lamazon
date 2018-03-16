package dhbw.lamazon.servlets;

import dhbw.lamazon.Messages;
import dhbw.lamazon.enums.UserCommunication;

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
        "/abmelden"
})
public class AbmeldenServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        // Den User aus der Session löschen
        session.removeAttribute("user");
        Messages.add(UserCommunication.LOGOUT_SUCCESSFUL);

        response.sendRedirect("/lamazon");
    }
}
