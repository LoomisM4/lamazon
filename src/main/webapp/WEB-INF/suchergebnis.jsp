<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var="article" items="${articles}">
    <div>
        <h4>${article.getTitle()}</h4>
    </div>
</c:forEach>
