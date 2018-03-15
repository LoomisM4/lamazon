package dhbw.lamazon.servlets;

import dhbw.lamazon.Errors;

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
        "/posteingang"
})
public class PosteingangServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        if (user == null) {
            Errors.add("Sie müssen eingeloggt sein, um diesen Bereich zu betreten");
            response.sendRedirect("/anmelden");
        } else {
            new Dispatcher(request, response).navigateTo("posteingang.jsp");
        }
    }
}
