package enums;

public enum EmailKey {

    EMAIL("email_user"),
    SID_TOKEN("sid_token");

    private final String label;

    public String getLabel() {
        return label;
    }

    EmailKey(String label) {
        this.label = label;
    }
}
