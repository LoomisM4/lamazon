function activateChangeFields() {
    // Alle Eingabefelder freischalten und gleichzeitig die alte Anzeige ausblenden
    var benutzername = document.getElementsByName("benutzername");
    benutzername.removeAttribute("hidden");
    document.getElementById("benutzername").setAttribute("hidden", true);
    var vorname = document.getElementsByName("vorname");
    vorname.removeAttribute("hidden");
    document.getElementById("vorname").setAttribute("hidden", true);
    var nachname = document.getElementsByName("nachname");
    nachname.removeAttribute("hidden");
    document.getElementById("nachname").setAttribute("hidden", true);
    var strasse = document.getElementsByName("strasse");
    strasse.removeAttribute("hidden");
    document.getElementById("strasse").setAttribute("hidden", true);
    var hausnr = document.getElementsByName("hausnr");
    hausnr.removeAttribute("hidden");
    document.getElementById("hausnr").setAttribute("hidden", true);
    var plz = document.getElementsByName("plz");
    plz.removeAttribute("hidden");
    document.getElementById("plz").setAttribute("hidden", true);
    var ort = document.getElementsByName("ort");
    ort.removeAttribute("hidden");
    document.getElementById("ort").setAttribute("hidden", true);
    var email = document.getElementsByName("email");
    email.removeAttribute("hidden");
    document.getElementById("email").setAttribute("hidden", true);
    var passwort = document.getElementsByName("passwort");
    passwort.removeAttribute("hidden");
    document.getElementById("passwort").setAttribute("hidden", true);

    // Beide neuen Buttons sichtbar machen
    document.getElementById("speichern").removeAttribute("hidden");
    document.getElementById("abbrechen").removeAttribute("hidden");
}

function deactivateChangeFields() {

}