<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <c:forEach var="message" items="${user.getReceivedMessages()}">
        <div class="row">
            <div class="col-7">
                <a href="${url}/nachricht?id=${message.getId()}">
                    <c:out value="${message.getSender()}"/>
                </a>
            </div>
            <div class="col-3">
                <c:out value="${message.getDate()}"/>
            </div>
        </div>
    </c:forEach>
</div>