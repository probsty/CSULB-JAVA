package decorator;

public enum LineWeight {
    LIGHT, MEDIUM, HEAVY;

    public String toString () {
        return this.name().toLowerCase();
    }
}