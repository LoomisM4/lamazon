<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <div class="row">
        <c:if test="${articles.size() >= 3}">
            <div class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner" style="height: 50%">
                    <div class="carousel-item active">
                        <img class="d-block w-100" src="img/1.jpg" alt="First slide" style="width: 100%; height: 100%">
                        <div class="carousel-caption d-none d-md-block">
                            <h5>${articles.get(0).getTitle()}</h5>
                            <p>${articles.get(0).getShortDescription()}</p>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="img/2.jpg" alt="Second slide" style="width: 100%; height: 100%">
                        <div class="carousel-caption d-none d-md-block">
                            <h5>${articles.get(1).getTitle()}</h5>
                            <p>${articles.get(1).getShortDescription()}</p>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="img/3.jpg" alt="Third slide" style="width: 100%; height: 100%">
                        <div class="carousel-caption d-none d-md-block">
                            <h5>${articles.get(2).getTitle()}</h5>
                            <p>${articles.get(2).getShortDescription()}</p>
                        </div>
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Vorheriges</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Nächstes</span>
                </a>
            </div>
        </c:if>
    </div>
    <div class="row">
        <div class="col">
            <br>
            <h4>Weitere Artikel</h4>
        </div>
    </div>
    <div class="row">
        <div class="container-fluid">
            <c:forEach var="article" items="${articles}">
                <div class="row" style="border-style: solid; border-color: black; border-width: thin; margin-bottom: 1px">
                    <div class="col">
                        <a href="${url}/artikel?id=${article.getId()}">
                            <img src="Bidl.jpg" alt="Bild" width="80px" height="80px">
                        </a>
                    </div>
                    <div class="col-8">
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
    </div>
</div>