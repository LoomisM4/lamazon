package dhbw.lamazon.servlets;

import dhbw.lamazon.beans.UserBean;

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
        "/favoriten"
})
public class FavoritenServlet extends HttpServlet {
    @EJB
    UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object o = session.getAttribute("user");

        if (o != null) {
            //User user = userBean.update((User) o);
            //session.setAttribute("user", user);
        }
        new Dispatcher(request, response).navigateTo("favoriten.jsp");
    }
}
