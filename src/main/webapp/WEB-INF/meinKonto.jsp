<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- Hier werden die persönlichen Daten angezeigt --%>
<div>
    <h3>Meine Daten</h3>
    <br>
    <form method="post">
        <div class="container">
            <div class="row">
                <div class="col">
                    Benutzername:
                </div>
                <div class="col">
                    <div id="benutzername"><c:out value="${user.getBenutzername()}"/></div>
                    <div class="form-group">
                        <input type="text" class="form-control" value="${user.getBenutzername()}" name="benutzername" hidden>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    Vorname:
                </div>
                <div class="col">
                    <div id="vorname"><c:out value="${user.getVorname()}"/></div>
                    <div class="form-group">
                        <input type="text" class="form-control" value="${user.getVorname()}" name="vorname" hidden>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    Nachname:
                </div>
                <div class="col">
                    <div id="nachname"><c:out value="${user.getNachname()}"/></div>
                    <div class="form-group">
                        <input type="text" class="form-control" value="${user.getNachname()}" name="nachname" hidden>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    Strasse:
                </div>
                <div class="col">
                    <div id="strasse"><c:out value="${user.getStrasse()}"/></div>
                    <div class="form-group">
                        <input type="text" class="form-control" value="${user.getStrasse()}" name="strasse" hidden>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    Hausnummer:
                </div>
                <div class="col">
                    <div id="hausnr"><c:out value="${user.getHausnr()}"/></div>
                    <div class="form-group">
                        <input type="text" class="form-control" value="${user.getHausnr()}" name="hausnr" hidden>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    Postleitzahl:
                </div>
                <div class="col">
                    <div id="plz"><c:out value="${user.getPlz()}"/></div>
                    <div class="form-group">
                        <input type="text" class="form-control" value="${user.getPlz()}" name="plz" hidden>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    Ort:
                </div>
                <div class="col">
                    <div id="ort"><c:out value="${user.getOrt()}"/></div>
                    <div class="form-group">
                        <input type="text" class="form-control" value="${user.getOrt()}" name="ort" hidden>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    E-Mail-Adresse:
                </div>
                <div class="col">
                    <div id="email"><c:out value="${user.getEmail()}"/></div>
                    <div class="form-group">
                        <input type="text" class="form-control" value="${user.getEmail()}" name="email" hidden>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    Passwort:
                </div>
                <div class="col">
                    <div id="passwort">das Passwort wird nicht angezeigt</div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="passwort" hidden>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <button class="btn btn-primary" type="button" onclick="activateChangeFields()">Daten ändern</button>
                    <button class="btn btn-primary" id="speichern" type="submit" hidden>Speichern</button>
                </div>
                <div class="col">
                    <button class="btn btn-primary" id="abbrechen" onclick="deactivateChangeFields()" hidden>Abbrechen</button>
                </div>
            </div>
        </div>
    </form>
</div>
<br>
<%-- Hier werden die bereits eingestellten Artikel angezeigt angezeigt --%>
<div>
    <h3>Bereits eingestellte Artikel</h3>
    <c:choose>
        <c:when test="${empty articles}">
            <div>Sie haben bisher noch keine Artikel zum Verkauf angeboten</div>
        </c:when>
        <c:otherwise>
            <c:forEach var="article" items="${articles}">
                <div>
                    <a href="${url}/artikel?id=${article.getId()}">${article.getTitle()}</a>
                </div>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</div>