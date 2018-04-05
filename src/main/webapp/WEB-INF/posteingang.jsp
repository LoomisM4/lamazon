
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">

    <h2 style="margin-bottom: 3%">Posteingang</h2>
    <table>
        <tr style="background-color: lightgray">
            <th>
                Absender
            </th>
            <th>
                Betreff
            </th>
            <th>
                Datum
            </th>
        </tr>

        <c:forEach var="message" items="${user.getReceivedMessages()}">
            <colgroup>
                <col width="25%">
                <col width="75%">
                <col width="25%">
            </colgroup>
            <tr style="height: 20px; border-bottom: 1px solid #000">
                <td>
                    <a href="${url}/nachricht?id=${message.getId()}">
                        <c:out value="${message.getSender().getBenutzername()}"/>
                    </a>
                </td>
                <td>
                    <a href="${url}/nachricht?id=${message.getId()}">
                        <c:choose>
                            <c:when test="${message.getSubject()!= null}">
                                <c:out value="${message.getSubject()}"/>
                            </c:when>
                            <c:otherwise>
                                Kein Betreff
                            </c:otherwise>
                        </c:choose>
                    </a>
                </td>
                <td>
                    <c:out value="${message.getDate()}"/>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>