package dhbw.lamazon.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

class Dispatcher {

    public static String baseUrl;

    private HttpServletRequest request;
    private HttpServletResponse response;

    public Dispatcher(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    /**
     * Leitet die Anfrage zentral an eine JSP weiter.
     *
     * @param targetJsp Der Name der JSP-Datei, ohne deren Speicherort (außer, sie liegt in einem Unterverzechnis von WEB-INF)
     *
     * @throws ServletException
     * @throws IOException
     */
    public void navigateTo(String targetJsp) throws ServletException, IOException {
        // die Basis-URL der Anwendung in der Session speichern, damit diese als Basis für die Navigation verwendet werden kann
        // (nur falls das noch nicht passiert ist) + in baseUrl speichern
        if (Dispatcher.baseUrl == null) {
            Dispatcher.baseUrl = request.getRequestURL().toString();
            HttpSession session = this.request.getSession();
            session.setAttribute("url", Dispatcher.baseUrl);
        }
        this.request.setAttribute("body", targetJsp);

        this.request.getRequestDispatcher("/WEB-INF/template.jsp").forward(this.request, this.response);
    }
}
