<%@ page import="dhbw.lamazon.Errors" %>
<%@ page import="dhbw.lamazon.Messages" %>
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
<main style="margin-bottom: 80px; margin-left: 20px; margin-right: 20px">
    <div class="container">
        <div class="row">
            <div class="col">
                <%-- Hier wird eine Nachricht, nach z. B. dem erfolgreichen ausloggen angezeigt --%>
                <div id="message">
                    <c:forEach var="message" items="${messages}">
                        <div class="row">
                            <c:out value="${message}"/>
                        </div>
                    </c:forEach>
                    <% Messages.clear(); %>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <%-- Hier werden evtl. vorhandene Fehler angezeigt --%>
                <div id="error">
                    <c:forEach var="error" items="${errors}">
                        <div class="row">
                            <c:out value="${error}"/>
                        </div>
                    </c:forEach>
                    <% Errors.clear(); %>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <%-- Einbindung der jeweils benötigen JSP (steht in "body" der Session) --%>
                <jsp:include page="${body}"/>
            </div>
        </div>
    </div>
</main>
<footer>
    <%-- Hier kann der Footer eingebunden werden --%>
    <jsp:include page="footer.jsp"/>
</footer>
</body>
</html>
