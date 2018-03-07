<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${empty articles}">
        <div>
            Ihre Suche ergab leider keine Treffer
        </div>
    </c:when>
    <c:otherwise>
        <c:forEach var="article" items="${articles}">
            <div>
                <h4>${article.getTitle()}</h4>
            </div>
        </c:forEach>
    </c:otherwise>
</c:choose>
