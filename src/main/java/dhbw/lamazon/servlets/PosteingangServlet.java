package dhbw.lamazon.servlets;

import dhbw.lamazon.SecurityCheck;
import dhbw.lamazon.beans.UserBean;
import dhbw.lamazon.entities.User;

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
        "/posteingang"
})
public class PosteingangServlet extends HttpServlet {
    @EJB
    private UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (SecurityCheck.isUserLoggedIn(request, response)) {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            user = userBean.findById(user.getId());
            session.setAttribute("user", user);
            new Dispatcher(request, response).navigateTo("posteingang.jsp");
        }
    }
}
