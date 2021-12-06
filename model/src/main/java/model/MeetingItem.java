package model;

import java.io.Serializable;
import java.util.Objects;

public class MeetingItem implements Serializable {
    private final String description;
    private final Delegate speaker;
    private final InterventionPriorityQueue interventionQueue;
    private Intervention currentIntervention;

    public MeetingItem(String description, Delegate speaker) {
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

    public void nextIntervention() {
        currentIntervention = interventionQueue.pop();
    }

    @Override
    public int hashCode(){
        return Objects.hash(description, speaker);
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof MeetingItem other){
            return this.description.equals(other.description)
                    && this.speaker.equals(other.speaker);
        }

        return false;
    }
}
