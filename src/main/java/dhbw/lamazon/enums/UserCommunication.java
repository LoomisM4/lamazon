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
    PRICE_WRONG;

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
            default:
                return "Das ist etwas schief gelaufen";
        }
    }
}