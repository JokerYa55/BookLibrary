package app.controllers;

/**
 *
 * @author vasil
 */
public enum PagesType {
    LOGIN_PAGE("login"),
    INDEX_PAGE("index"),
    TRASH_PAGE("trash"),
    REGISTRATION_PAGE("registration");
    
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
