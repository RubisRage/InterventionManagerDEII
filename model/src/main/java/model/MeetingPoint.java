package model;

public class MeetingPoint {
    private final String description;
    private final Delegate speaker;
    private final InterventionPriorityQueue interventionQueue;
    private Intervention currentIntervention;

    public MeetingPoint(String description, Delegate speaker) {
        this.description = description;
        this.speaker = speaker;
        interventionQueue = new InterventionPriorityQueue();
        currentIntervention = null;
    }

    public Intervention getCurrentIntervention(){
        return currentIntervention;
    }

    public void addIntervention(Intervention newIntervention){
        interventionQueue.push(newIntervention);
    }

    public void cancelIntervention(Intervention canceledIntervention){
        interventionQueue.remove(canceledIntervention);
    }

    public void endCurrentIntervention(){
        currentIntervention = null;
    }

    public void passIntervention() {
        currentIntervention = interventionQueue.pop();
    }
}
