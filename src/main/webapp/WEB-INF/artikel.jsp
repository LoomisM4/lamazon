<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h4><c:out value="${article.getTitle()}"/></h4>
<br>
<div class="container">
    <div class="row">
        <div class="col">
            <img src="${url}/image?articleId=${article.getId()}" alt="Bild" style="max-height: 500px; max-width: 500px">
        </div>
        <div class="col">
            <h3><c:out value="${article.getPrice()}"/> EUR</h3>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <br><br>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <a href="${url}/zufavoriten?artikel=${article.getId()}">
                <button type="button" class="btn btn-primary">Merken</button>
            </a>
        </div>
        <div class="col">
            <a href="${url}/neuenachricht">
                <button type="button" class="btn btn-primary">Nachricht an Verk&#228;ufer</button>
            </a>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <br><br>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <b>Beschreibung:</b>
            <br><br>
            <c:out value="${article.getDescription()}"/>
        </div>
    </div>
</div>