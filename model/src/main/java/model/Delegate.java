package model;

public class Delegate {
    private final String username;
    private final String fullname;
    private final Boolean isModerator;

    public Delegate(String username, String fullname) {
        this.username       = username;
        this.fullname       = fullname;
        this.isModerator    = false;
    }

    public Delegate(String username, String fullname, Boolean isModerator) {
        this.username       = username;
        this.fullname       = fullname;
        this.isModerator    = isModerator;
    }

    public String getFullname() {
        return fullname;
    }

    public String getUsername() {
        return username;
    }

    public Boolean isModerator(){
        return isModerator;
    }

    public Intervention createIntervention(InterventionType interventionType){
        return new Intervention(this, interventionType);
    }
}
