<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>lamazon</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
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
  <main>
      <%-- Einbindung der jeweils benötigen JSP (steht in "body" der Session) --%>
      <jsp:include page="${body}"/>
  </main>
  <footer>
      <%-- Hier kann der Footer eingebunden werden --%>
      <jsp:include page="footer.jsp"/>
  </footer>
  </body>
</html>
