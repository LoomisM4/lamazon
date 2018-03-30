<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty user}">
    <c:choose>
        <c:when test="${empty user.getFavorites()}">
            Sie haben aktuell noch keine Artikel zu Ihren Favoriten hinzugefügt
        </c:when>
        <c:otherwise>
            <c:forEach var="favorit" items="${user.getFavorites()}">
                <div>
                    <a href="/artikel?id=${favorit.getArticle().getId()}">
                        <c:out value="${favorit.getArticle().getTitle()}"/>
                    </a>
                </div>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</c:if>