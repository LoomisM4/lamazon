package dhbw.lamazon.enums;

/**
 * @author Marcel Wettach
 */
public enum UserCommunication {
    ERROR,
    MAIL_ALREADY_AVAILABLE,
    LOGOUT_SUCCESSFUL,
    MISSING_FIELDS,
    ARTICLE_NOT_FOUND,
    LOGIN_REQUIRED,
    WRONG_ZIP_CODE,
    CHANGES_SUCCESSFUL,
    MESSAGE_SENT,
    ARTICLE_PUBLISHED,
    PASSWORDS_DIFFERENT,
    AGB_UNCHECKED,
    ACCOUNT_CREATED,
    LOGIN_FAILED,
    PRICE_WRONG,
    IMAGE_TOO_BIG,
    ARTIKEL_BEREITS_FAVORIT,
    LOGIN_SUCCESFUL,
    NO_RIGHTS,
    MESSAGE_DELETETD,
    ARTICLE_DELETED;

    public String toString() {
        switch (this) {
            case MAIL_ALREADY_AVAILABLE:
                return "Zu jeder E-Mail-Adresse darf nur ein Konto vorhanden sein";
            case LOGOUT_SUCCESSFUL:
                return "Sie wurden erfolgreich ausgeloggt";
            case MISSING_FIELDS:
                return "Bitte füllen Sie alle Felder aus";
            case ARTICLE_NOT_FOUND:
                return "Der gesuchte Artikel wurde nicht gefunden";
            case LOGIN_REQUIRED:
                return "Sie müssen eingeloggt sein, um diesen Bereich zu betreten";
            case WRONG_ZIP_CODE:
                return "Geben Sie eine gültige PLZ an";
            case CHANGES_SUCCESSFUL:
                return "Ihre Daten wurden erfolgreich geändert";
            case MESSAGE_SENT:
                return "Nachricht wurde versandt";
            case ARTICLE_PUBLISHED:
                return "Ihr Artikel wurde erfolgreich eingestellt";
            case PASSWORDS_DIFFERENT:
                return "Die beiden Passwörter müssen übereinstimmen";
            case AGB_UNCHECKED:
                return "Bitte akzeptieren sie die AGB";
            case ACCOUNT_CREATED:
                return "Ihr Konto wurde erfolgreich angelegt";
            case LOGIN_FAILED:
                return "E-Mail-Adresse oder Passwort falsch";
            case PRICE_WRONG:
                return "Geben Sie einen gültigen Preis ein";
            case IMAGE_TOO_BIG:
                return "Das Artikelbild darf maximal 4 MB groß sein";
            case ARTIKEL_BEREITS_FAVORIT:
                return "Der ausgewählte Artikel wurde bereits zu den Favoriten hinzugefügt";
            case LOGIN_SUCCESFUL:
                return "Sie wurden erfolgreich eingeloggt";
            case NO_RIGHTS:
                return "Für die angeforderte Aktion haben Sie nicht die nötigen Berechtigungen";
            case MESSAGE_DELETETD:
                return "Die Nachricht wurde gelöscht";
            case ARTICLE_DELETED:
                return "Der Artikel wurde erfolgreich gelöscht";
            default:
                return "Das ist etwas schief gelaufen";
        }
    }
}
