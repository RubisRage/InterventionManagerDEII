package model;

public class Delegate {
    private final String username;
    private final String fullname;

    public Delegate(String username, String fullname) {
        this.username = username;
        this.fullname = fullname;
    }

    public String getFullname() {
        return fullname;
    }

    public String getUsername() {
        return username;
    }
}
