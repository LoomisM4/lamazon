<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-sm navbar-dark" style="background-color: #0066CC;">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".dual-nav" aria-controls="navbarToggler" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="navbar-collapse collapse dual-nav w-100">
        <ul class="navbar-nav">
            <c:if test="${empty user}">
                <li class="nav-item active" style="padding-right: 20px">
                    <a class="nav-link" href="${url}/registrieren">Registrieren</a>
                </li>
                <li class="nav-item active" style="padding-right: 20px">
                    <a class="nav-link" href="${url}/anmelden">Anmelden</a>
                </li>
            </c:if>
            <li class="nav-item active" style="padding-right: 20px">
                <a class="nav-link" href="${url}/kontakt">Kontakt</a>
            </li>
        </ul>
    </div>
    <div class="navbar-collapse collapse dual-nav">
        <ul class="navbar-nav">
            <c:if test="${not empty user}">
                <li class="nav-item active" style="margin-right: auto; margin-left: auto">
                    <a class="nav-link" href="${url}/abmelden">Abmelden</a>
                </li>
                <li class="nav-item active" style="margin-right: auto; margin-left: auto">
                    <a class="nav-link" href="${url}/meinkonto">Mein Lamazon</a>
                </li>
            </c:if>
            <a class="navbar-brand" href="${url}/warenkorb">
                <img src="img/warenkorb.png" width="30", height="30">
            </a>
        </ul>
    </div>
</nav>