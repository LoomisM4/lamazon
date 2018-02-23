<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>lamazon</title>
  </head>
  <body>
    <!-- Einbindung der Navigation -->
    <jsp:include page="navigation.jsp"></jsp:include>
  
    <!-- Einbindung der jeweils benötigen JSP (steht in "body" der Session -->
    <jsp:include page="${body}"></jsp:include>
  </body>
</html>
