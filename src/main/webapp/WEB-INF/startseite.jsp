<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <div class="row">
        <c:if test="${articles.size() >= 3}">
            <div id="carousel" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carousel" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel" data-slide-to="1"></li>
                    <li data-target="#carousel" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner" style="height: 50%">
                    <div class="carousel-item active">
                        <a href="${url}/artikel?id=${articles.get(articles.size() - 1).getId()}">
                            <img class="d-block w-100" src="${url}/image?articleId=${articles.get(articles.size() - 1).getId()}" alt="Bild" style="width: 100%; height: 100%">
                            <div class="carousel-caption d-none d-md-block" style="background-color: rgba(0, 83, 166, 0.5); padding: 5px; border-radius: 30px;">
                                <h5>${articles.get(articles.size() - 1).getTitle()}</h5>
                                <p>${articles.get(articles.size() - 1).getShortDescription()}</p>
                            </div>
                        </a>
                    </div>
                    <div class="carousel-item">
                        <a href="${url}/artikel?id=${articles.get(articles.size() - 2).getId()}">
                            <img class="d-block w-100" src="${url}/image?articleId=${articles.get(articles.size() - 2).getId()}" alt="Bild" style="width: 100%; height: 100%">
                            <div class="carousel-caption d-none d-md-block" style="background-color: rgba(0, 83, 166, 0.5); padding: 5px; border-radius: 30px;">
                                <h5>${articles.get(articles.size() - 2).getTitle()}</h5>
                                <p>${articles.get(articles.size() - 2).getShortDescription()}</p>
                            </div>
                        </a>
                    </div>
                    <div class="carousel-item" style="min-width: 100%">
                        <a href="${url}/artikel?id=${articles.get(articles.size() - 3).getId()}">
                            <img class="d-block w-100" src="${url}/image?articleId=${articles.get(articles.size() - 3).getId()}" alt="Bild" style="width: 100%; height: 100%">
                            <div class="carousel-caption d-none d-md-block" style="background-color: rgba(0, 83, 166, 0.5); padding: 5px; border-radius: 30px;">
                                <h5>${articles.get(articles.size() - 3).getTitle()}</h5>
                                <p>${articles.get(articles.size() - 3).getShortDescription()}</p>
                            </div>
                        </a>
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carousel" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Vorheriges</span>
                </a>
                <a class="carousel-control-next" href="#carousel" role="button" data-slide="next">
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
                            <img src="${url}/image?articleId=${article.getId()}" alt="Bild" width="80px" height="80px">
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