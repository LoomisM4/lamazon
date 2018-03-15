<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <div class="row">
        <div class="col-2">
            <div class="row">
                <h3><c:out value="${article.getTitle()}"/></h3>
            </div>
            <div class="row">
                <c:out value="${article.getPrice()}"/> EUR
            </div>
        </div>
        <div class="col">
            <img src="Bild.jpg" alt="Bild">
        </div>
    </div>
    <br>
    <div>
        <c:out value="${article.getDescription()}"/>
    </div>
    <br>
    <div>
        <a href="${url}/neuenachricht">
            <button type="button" class="btn btn-primary">Nachricht an Verk&#228;ufer</button>
        </a>
    </div>
</div>