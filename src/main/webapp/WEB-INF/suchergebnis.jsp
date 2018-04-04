<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${empty articles}">
        <div>
            Ihre Suche ergab leider keine Treffer
        </div>
    </c:when>
    <c:otherwise>
        <div class="row">
            <div class="col">
                Ihre Suche ergab <c:out value="${articles.size()}"/> Treffer
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
    </c:otherwise>
</c:choose>
