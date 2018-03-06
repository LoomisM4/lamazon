<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var="article" items="${articles}">
    <div>
        ${article.getTitle()}
    </div>
    <div>
        ${article.getPrice()}
    </div>
</c:forEach>