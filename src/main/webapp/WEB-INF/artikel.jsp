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
            <img src="bild.jpg" alt="Bild">
        </div>
    </div>
    <br>
    <div>
        <c:out value="${article.getDescription()}"/>
    </div>
</div>