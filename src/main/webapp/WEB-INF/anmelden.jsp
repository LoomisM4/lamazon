<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form method="post">
    <div class="form-group">
        <input class="form-control" placeholder="E-Mail-Adresse" name="email">
    </div>
    <div class="form-group">
        <input class="form-control"placeholder="Passwort" name="passwort">
    </div>
    <button type="submit" class="btn btn-primary">Einloggen</button>
</form>
<br>
<c:forEach var="error" items="${errors}">
    <div><c:out value="${error}"/></div>
</c:forEach>