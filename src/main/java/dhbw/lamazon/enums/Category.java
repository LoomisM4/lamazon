package dhbw.lamazon.enums;

public enum Category {
    TECHNIK, HAUSHALT;

    public static Category getCategory(String s) {
        switch (s) {
            case "Technik":
                return TECHNIK;
            case "Haushalt":
                return HAUSHALT;
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        switch(this) {
            case TECHNIK:
                return "Technik";
            case HAUSHALT:
                return "Haushalt";
            default:
                return "EnumError";
        }
    }
}
