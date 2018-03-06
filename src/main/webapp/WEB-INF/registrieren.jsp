<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
    <img src="img/logo.jpg">
</div>
<form method="post">
    <div class="form-group">
        <label>Benutzername:</label>
        <input type="text" class="form-control" placeholder="Benutzername" name="benutzername">
    </div>
    <div class="form-group">
        <label>E-Mail-Adresse:</label>
        <input type="email" class="form-control" placeholder="E-Mail-Adresse" name="email">
    </div>
    <div class="form-group">
        <label>Passwort:</label>
        <input type="text" class="form-control" placeholder="Passwort" name="passwort1">
    </div>
    <div class="form-group">
        <label>Passwort wiederholen:</label>
        <input type="text" class="form-control" placeholder="Passwort" name="passwort2">
    </div>
    <div class="form-check">
        <input type="checkbox" class="form-check-input" name="agb">
        <label class="form-check-label">Ich stimme den AGB zu.</label>
    </div>
    <button type="submit" class="btn btn-primary">Registrieren</button>
</form>
<br>
<c:forEach var="error" items="${errors}">
    <div><c:out value="${error}"/></div>
</c:forEach>