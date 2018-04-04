<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <div class="row">
        <div class="col">
            <h3>Nachricht von ${message.getSender().getBenutzername()}</h3>
        </div>
    </div>
    <div class="row">
        <div class="col-4">
            <h4>Betreff:</h4>
        </div>
        <div class="col">
            <h4>${message.getSubject()}</h4>
        </div>
    </div>
    <div class="row">
        <div class="col">
            Inhalt:
        </div>
    </div>
    <div class="row">
        <div class="col">
            <c:out value="${message.getMessage()}"/>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <form action="antworten">
                <input type="hidden" value="${message.getId()}" name="id">
                <button type="submit" class="btn btn-primary">Antworten</button>
            </form>
        </div>
        <div class="col">
            <form method="post">
                <button type="submit" class="btn btn-danger">L&#246;schen</button>
            </form>
        </div>
    </div>
</div>
