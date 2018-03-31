package dhbw.lamazon.enums;

public enum Category {
    ALLE, TECHNIK, HAUSHALT, LEBENSMITTEL, TICKETS, FAMILIE, FREIZEIT, MODE, MUSIK, FILME, BUECHER, ANDERES;

    public static Category getCategory(String s) {
        switch (s) {
            case "Alle":
                return ALLE;
            case "Technik":
                return TECHNIK;
            case "Haushalt":
                return HAUSHALT;
            case "Lebensmittel":
                return LEBENSMITTEL;
            case "Tickets":
                return TICKETS;
            case "Familie":
                return FAMILIE;
            case "Freizeit":
                return FREIZEIT;
            case "Mode":
                return MODE;
            case "Musik":
                return MUSIK;
            case "Filme":
                return FILME;
            case "Bücher":
                return BUECHER;
            default:
                return ANDERES;
        }
    }

    @Override
    public String toString() {
        switch(this) {
            case ALLE:
                return "Alle";
            case TECHNIK:
                return "Technik";
            case HAUSHALT:
                return "Haushalt";
            case LEBENSMITTEL:
                return "Lebensmittel";
            case TICKETS:
                return "Tickets";
            case FAMILIE:
                return "Familie";
            case FREIZEIT:
                return "Freizeit";
            case MODE:
                return "Mode";
            case MUSIK:
                return "Musik";
            case FILME:
                return "Filme";
            case BUECHER:
                return "Bücher";
            default:
                return "Anderes";
        }
    }

    public static boolean contains(Category category) {
        for (Category c : Category.values()) {
            if (c.equals(category))
                return true;
        }
        return false;
    }
}
