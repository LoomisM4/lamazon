package dhbw.lamazon.servlets;

import dhbw.lamazon.Errors;
import dhbw.lamazon.Messages;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * mit einem Objekt dieser Klasse kann die Navigation innerhalb einer Webanwendung
 * realisiert werden.
 *
 * @author Marcel Wettach
 */
class Dispatcher {

    public static String baseUrl;

    private HttpServletRequest request;
    private HttpServletResponse response;

    /**
     * Konstruktor für ein neues Dispatcher-Onjekt
     *
     * @param request das HttpServletRequest-Objekt der Anfrage
     * @param response das HttpServletResponse-Objekt der Anfrage
     */
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
        this.request.setAttribute("errors", Errors.getErrors());
        this.request.setAttribute("messages", Messages.getMessages());
        this.request.setAttribute("body", targetJsp);

        this.request.getRequestDispatcher("/WEB-INF/template.jsp").forward(this.request, this.response);
    }
}
