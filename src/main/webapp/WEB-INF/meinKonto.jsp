<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <%-- Hier werden die persönlichen Daten angezeigt --%>
    <div class="row">
        <div class="col">
            <h3>Meine Lamazon</h3>
            <br>
        </div>
    </div>
    <div class="row">
        <div class="col">
            Benutzername: ${user.getBenutzername()}
        </div>
    </div>
    <br>
    <div class="row">
        <div class="col">
            <h3>Allgemeine Kontoeinstellungen:</h3>
            <br>
        </div>
    </div>
    <form method="post">
        <div class="row">
            <div class="col">
                Vorname:
            </div>
            <div class="col-6">
                <div class="form-group">
                    <input type="text" class="form-control" value="${user.getVorname()}" name="vorname">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                Nachname:
            </div>
            <div class="col-6">
                <div class="form-group">
                    <input type="text" class="form-control" value="${user.getNachname()}" name="nachname">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                E-Mail-Adresse:
            </div>
            <div class="col-6">
                <div class="form-group">
                    <input type="text" class="form-control" value="${user.getEmail()}" name="email">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                Passwort:
            </div>
            <div class="col-6">
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="das Passwort wird nicht angezeigt"
                           name="passwort">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                Strasse:
            </div>
            <div class="col-6">
                <div class="form-group">
                    <input type="text" class="form-control" value="${user.getStrasse()}" name="strasse">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                Hausnummer:
            </div>
            <div class="col-6">
                <div class="form-group">
                    <input type="text" class="form-control" value="${user.getHausnr()}" name="hausnr">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                Postleitzahl:
            </div>
            <div class="col-6">
                <div class="form-group">
                    <input type="text" class="form-control" value="${user.getPlz()}" name="plz">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                Ort:
            </div>
            <div class="col-6">
                <div class="form-group">
                    <input type="text" class="form-control" value="${user.getOrt()}" name="ort">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <button class="btn btn-primary" type="submit">Änderungen speichern</button>
                <br>
            </div>
        </div>
    </form>
    <%-- Hier werden die bereits eingestellten Artikel angezeigt angezeigt --%>
    <div class="row">
        <div class="col">
            <br>
            <h3>Bereits eingestellte Artikel</h3>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <br>
            <c:choose>
                <c:when test="${empty articles}">
                    <div class="row">Sie haben bisher noch keine Artikel zum Verkauf angeboten</div>
                </c:when>
                <c:otherwise>
                    <c:forEach var="article" items="${articles}">
                        <div class="row">
                            <div class="col"-8>
                                <a href="${url}/artikel?id=${article.getId()}">${article.getTitle()}</a>
                            </div>
                            <div class="col">
                                <form action="artikelentfernen">
                                    <input type="hidden" value="${article.getId()}" name="id">
                                    <button type="submit" class="btn btn-danger">L&#246;schen</button>
                                </form>
                            </div>
                        </div>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>