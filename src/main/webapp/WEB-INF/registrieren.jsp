<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div style="display: flex; align-content: center; justify-content: center">
    <form method="post">
        <div class="form-group">
            <img src="img/logo.jpg">
        </div>
        <div style="border-color: black; border-style: solid; border-width: thin; padding: 10px">
            <div class="form-group">
                <h3>Konto anlegen</h3>
            </div>
            <div class="form-group">
                <input type="text" class="form-control form-control-sm" placeholder="Benutzername" size="30px" name="benutzername">
            </div>
            <div class="form-group">
                <input type="email" class="form-control form-control-sm" placeholder="E-Mail-Adresse" name="email">
            </div>
            <div class="form-group">
                <input type="password" class="form-control form-control-sm" placeholder="Passwort" name="passwort1">
            </div>
            <div class="form-group">
                <input type="password" class="form-control form-control-sm" placeholder="Passwort" name="passwort2">
            </div>
            <div class="form-group">
                <input type="text" class="form-control form-control-sm" placeholder="Vorname" name="vorname">
            </div>
            <div class="form-group">
                <input type="text" class="form-control form-control-sm" placeholder="Nachname" name="nachname">
            </div>
            <div class="form-group">
                <input type="text" class="form-control form-control-sm" placeholder="Straße und Hausnummer" name="strasse">
            </div>
            <div id="row">
                <div id="col">
                    <div class="form-group">
                        <input type="text" class="form-control form-control-sm" placeholder="Postleitzahl" name="plz">
                    </div>
                </div>
                <div id="col">
                    <div class="form-group">
                        <input type="text" class="form-control form-control-sm" placeholder="Ort" name="ort">
                    </div>
                </div>
            </div>
            <div class="form-check">
                <input type="checkbox" class="form-check-input" name="agb">
                <label class="form-check-label">Ich stimme den AGB zu.</label>
            </div>
            <br>
            <button type="submit" class="btn btn-primary">Registrieren</button>
        </div>
    </form>
</div>