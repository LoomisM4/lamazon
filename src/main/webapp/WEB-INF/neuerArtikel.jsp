<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form method="post" enctype="multipart/form-data">
    <div class="form-group">
        <h3>Neuer Artikel</h3>
    </div>
    <div class="form-group">
        <input type="text" class="form-control form-control-sm" placeholder="Bezeichnung" name="bezeichnung">
    </div>
    <div class="form-group">
        <input type="text" class="form-control form-control-sm"placeholder="Beschreibung" name="beschreibung">
    </div>
    <div class="form-group">
        <select class="form-control" name="kategorie">
            <c:forEach var="c" items="${categories}">
                <option>${c.toString()}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <input type="text" class="form-control form-control-sm" placeholder="Preis" name="preis">
    </div>
    <div class="form-group">
        <input type="file" class="form-control form-control-sm" name="bild">
    </div>
    <button type="submit" class="btn btn-primary">Speichern</button>
</form>