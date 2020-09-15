package app.controllers;

/**
 *
 * @author vasil
 */
public enum PagesType {
    INDEX_PAGE("index"),
    TRASH_PAGE("trash");
    
    private final String name;

    private PagesType(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
