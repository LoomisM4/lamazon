<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
      <title>lamazon</title>
      <meta charset="UTF-8">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
      <link rel="stylesheet" href="css/style.css">
  </head>
  <body>
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
  <header>
      <%-- Hier wird die Navigationsleiste eingebunden --%>
      <jsp:include page="navigation.jsp"/>
      <%-- Hier wird die Toolbar zum Suchen nach Artikeln eingebunden --%>
      <jsp:include page="toolbar.jsp"/>
  </header>
  <main style="margin-bottom: 50px; margin-left: 20px; margin-right: 20px">
      <%-- Hier wird eine Nachricht, nach z. B. dem erfolgreichen ausloggen angezeigt --%>
      <div id="message">
          <c:out value="${message}"/>
      </div>
      <%-- Hier werden evtl. vorhandene Fehler angezeigt --%>
      <div id="error">
          <c:forEach var="error" items="${errors}">
              <div>
                  <c:out value="${error}"/>
              </div>
          </c:forEach>
      </div>
      <%-- Einbindung der jeweils benötigen JSP (steht in "body" der Session) --%>
      <jsp:include page="${body}"/>
  </main>
  <footer>
      <%-- Hier kann der Footer eingebunden werden --%>
      <jsp:include page="footer.jsp"/>
  </footer>
  </body>
</html>
