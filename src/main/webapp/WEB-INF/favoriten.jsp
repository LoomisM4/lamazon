<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<style>


    #price {
        float: right;
    }

    .left {
        float: left;
        width: 200px;
    }

    #right {
        float: right;
        width: 200px;
    }

    .middle {

        position: absolute;
        width: 200px;
        height: 150px;
        top: 60%;
        left: 50%;

    }

    .btn {

    }

</style>

<h1>Favoriten</h1>
<br>

<c:if test="${not empty user}">
    <c:choose>
        <c:when test="${empty user.getFavorites()}">
            Sie haben aktuell noch keine Artikel zu Ihren Favoriten hinzugef&#252gt
        </c:when>
        <c:otherwise>

            <form action="lamazon">
                <button float="left" type="submit" class="btn btn-primary">Weiter einkaufen</button>
            </form>

            <c:forEach var="favorit" items="${user.getFavorites()}">

                <div class="fav" id="fav"
                     style=" border-style: solid; border-color: black; border-width: thin; margin-bottom: 1px">


                    <div id="right">
                        <p id="price">
                                <c:out value="${favorit.getArticle().getPrice()}"/>
                            <br>
                        <form action="entfernenvonfavoriten">
                            <input type="hidden" value="${favorit.getId()}" name="id">
                            <button type="submit" class="btn btn-danger">L&#246;schen</button>
                        </form>

                        </p>
                    </div>


                    <a href="/artikel?id=${favorit.getArticle().getId()}">


                        <img src="${url}/image?articleId=${favorit.getArticle().getId()}" alt="Bild" width="75px"
                             height="75px">
                        <c:out value="${favorit.getArticle().getTitle()}"/>
                    </a>


                    <div class="middle">
                        <c:out value="${favorit.getArticle().getCategory()}"/>
                    </div>
                </div>


            </c:forEach>
        </c:otherwise>
    </c:choose>
</c:if>