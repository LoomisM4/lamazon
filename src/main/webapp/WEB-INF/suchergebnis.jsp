<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${empty articles}">
        <div>
            Ihre Suche ergab leider keine Treffer
        </div>
    </c:when>
    <c:otherwise>
        <div class="container">
            <c:forEach var="article" items="${articles}">
                <div class="row">
                    <div class="col">
                        <h4>${article.getTitle()}</h4>
                    </div>
                </div>
            </c:forEach>
        </div>
    </c:otherwise>
</c:choose>
