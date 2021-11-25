package model;

public class MeetingPoint {
    private final String description;
    private final Delegate speaker;
    private final InterventionPriorityQueue interventionQueue;

    public MeetingPoint(String description, Delegate speaker) {
        this.description = description;
        this.speaker = speaker;
        interventionQueue = new InterventionPriorityQueue();
    }


}
