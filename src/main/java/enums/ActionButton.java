package enums;

public enum ActionButton {
    YES("YES"),
    CANCEL("CANCEL"),
    SAVE("Save 3-word memo and ballot hash"),
    DISCARD("DISCARD"),
    DECRYPT("DECRYPT"),
    SIGN("SIGN"),
    SIGN_BALLOT("SIGN BALLOT");

    private final String label;

    ActionButton(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
