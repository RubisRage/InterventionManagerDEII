package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Intervention implements Comparable<Intervention>, Serializable {
    private final InterventionType type;
    private final LocalDateTime timestamp;
    private final Delegate owner;

    public Intervention(Delegate owner, InterventionType type)
    {
        this.owner = owner;
        this.type = type;
        timestamp = LocalDateTime.now();
    }

    public InterventionType getType() {
        return type;
    }

    @Override
    public int compareTo(Intervention other) {
        int priorityOrder = type.compareTo(other.type);
        if(priorityOrder == 0) {
            int timestampOrder = timestamp.compareTo(other.timestamp);
            if(timestampOrder == 0){
                return owner.getUsername().compareTo(other.owner.getUsername());
            }

            return timestampOrder;
        }

        return priorityOrder;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Intervention other)
            return this.compareTo(other) == 0;

        return false;
    }

    @Override
    public String toString(){
        return owner.getUsername() + "@" + type;
    }
}
