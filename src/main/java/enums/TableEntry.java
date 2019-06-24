package enums;

public enum TableEntry {

    EIKI_NESTOR("Eiki Nestor"),
    ESTONIA("Estonian Presidential Election");

    private final String label;

    TableEntry(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

}
