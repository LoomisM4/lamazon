<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div style="display: flex; align-content: center; justify-content: center">
    <form method="post">
        <div class="form-group">
            <input type="email" class="form-control form-control-sm" placeholder="E-Mail-Adresse" size="30px" name="email">
        </div>
        <div class="form-group">
            <input type="password" class="form-control form-control-sm"placeholder="Passwort" name="passwort">
        </div>
        <button type="submit" class="btn btn-primary">Einloggen</button>
    </form>
</div>
<br>
<c:forEach var="error" items="${errors}">
    <div><c:out value="${error}"/></div>
</c:forEach>