package dhbw.lamazon.enums;

public enum Category {
    TECHNIK, HAUSHALT;

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
