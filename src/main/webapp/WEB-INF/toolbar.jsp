<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div style="background-color: #0053A6;">
    <form class="form-inline" action="suchen">
        <div class="form-group">
            <a href="${url}/lamazon">
                <img src="img/logo.jpg" style="height: 50px">
            </a>
        </div>
        <div class="form-group" style="margin-left: 15px">
            <select class="form-control" name="kategorie">
                <c:forEach var="c" items="${categories}">
                    <option>${c.toString()}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col col-md-auto" style="margin-left: 10px">
            <div class="form-group">
                <input type="search" class="form-control form-control-sm" placeholder="Suche" size="100%" name="suchen">
            </div>
        </div>
    </form>
</div>