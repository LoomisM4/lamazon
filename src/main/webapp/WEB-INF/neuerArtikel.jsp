<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style type="text/css">
    .line {
        border-radius: 10px;
        background-color: lightblue;
        width: 100%;
        min-height: 10%;
        border-width: 10px;
        border-top: lightblue 10px solid;
        border-bottom: lightblue 5px solid;
        border-right: lightblue 5px solid;
        border-left: lightblue 5px solid;
        border-style: solid;
    }
</style>
<form method="post" enctype="multipart/form-data">
    <div class="form-group">
        <h3>Neuer Artikel</h3>
    </div>
    <div class="line">
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
            <input type="text" class="form-control form-control-sm"  placeholder="Preis" name="preis">
        </div>
    </div>
    <div class="form-group">
        <input type="file" style="margin-top: 2%" class="form-control form-control-sm" name="bild">
    </div>
    <button type="submit" class="btn btn-primary">Speichern</button>
</form>