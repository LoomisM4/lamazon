<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${articles.size() >= 3}">
    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img class="d-block w-40" src="..." alt="First slide">
                <div class="carousel-caption d-none d-md-block">
                    <h5>${articles.get(0).getTitle()}</h5>
                    <p>${articles.get(0).getDescription()}</p>
                </div>
            </div>
            <div class="carousel-item">
                <img class="d-block w-40" src="..." alt="Second slide">
                <div class="carousel-caption d-none d-md-block">
                    <h5>${articles.get(1).getTitle()}</h5>
                    <p>${articles.get(1).getDescription()}</p>
                </div>
            </div>
            <div class="carousel-item">
                <img class="d-block w-40" src="..." alt="Third slide">
                <div class="carousel-caption d-none d-md-block">
                    <h5>${articles.get(2).getTitle()}</h5>
                    <p>${articles.get(2).getDescription()}</p>
                </div>
            </div>
        </div>
        <a class="carousel-control-prev" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Vorheriges</span>
        </a>
        <a class="carousel-control-next" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Nächstes</span>
        </a>
    </div>
</c:if>

<br>
<h4>Weitere Artikel</h4>
<div class="container-fluid" style="width: 60%">
    <c:forEach var="article" items="${articles}">
        <div class="row" style="border-style: solid; border-color: black; border-width: thin; margin-bottom: 1px">
            <div class="col">
                <a href="${url}/artikel?id=${article.getId()}">
                    <img src="bild.jpg" alt="Bild" width="80px" height="80px">
                </a>
            </div>
            <div class="col-6">
                <div class="row">
                    <a href="${url}/artikel?id=${article.getId()}">
                        <h5><c:out value="${article.getTitle()}"/></h5>
                    </a>
                </div>
                <div class="row">
                    <c:out value="${article.getShortDescription()}"/>
                </div>
            </div>
            <div class="col">
                <c:out value="${article.getPrice()}"/> EUR
            </div>
        </div>
    </c:forEach>
</div>