package dhbw.lamazon.servlets;

import dhbw.lamazon.Errors;
import dhbw.lamazon.SecurityCheck;
import dhbw.lamazon.beans.MessageBean;
import dhbw.lamazon.entities.Message;
import dhbw.lamazon.enums.UserCommunication;

import javax.ejb.EJB;
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
        "/nachricht"
})
public class NachrichtServlet extends HttpServlet {
    @EJB
    private MessageBean messageBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (SecurityCheck.isUserLoggedIn(request, response) &&
                SecurityCheck.isUserAllowedToViewMessage(request, response)) {
            String idText = request.getParameter("id");
            long id = 0;
            try {
                id = Long.valueOf(idText);
            } catch (NumberFormatException e) {
                Errors.add(UserCommunication.ERROR);
            }
            Message message = messageBean.findMessageById(id);
            request.setAttribute("message", message);
            new Dispatcher(request, response).navigateTo("nachricht.jsp");
        }
    }
}
