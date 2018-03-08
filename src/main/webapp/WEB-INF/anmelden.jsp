<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div style="display: flex; align-content: center; justify-content: center">
    <form method="post">
        <div class="form-group">
            <img src="img/logo.jpg">
        </div>
        <div style="border-color: black; border-style: solid; border-width: thin; padding: 10px">
            <div class="form-group">
                <h3>Einloggen</h3>
            </div>
            <div class="form-group">
                <input type="email" class="form-control form-control-sm" placeholder="E-Mail-Adresse" size="30px" name="email">
            </div>
            <div class="form-group">
                <input type="password" class="form-control form-control-sm"placeholder="Passwort" name="passwort">
            </div>
            <button type="submit" class="btn btn-primary">Einloggen</button>
        </div>
    </form>
</div>