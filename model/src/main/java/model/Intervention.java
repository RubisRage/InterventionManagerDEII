package model;

import java.time.LocalDateTime;

public class Intervention implements Comparable<Intervention>{
    private final InterventionType type;
    private final LocalDateTime timestamp;
    private final Delegate owner;

    public Intervention(Delegate owner, InterventionType type)
    {
        this.owner = owner;
        this.type = type;
        timestamp = LocalDateTime.now();
    }

    @Override
    public int compareTo(Intervention other) {
        int priorityOrder = type.compareTo(other.type);
        if(priorityOrder == 0) {
            return timestamp.compareTo(other.timestamp);
        }

        return priorityOrder;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Intervention)
            return this.compareTo((Intervention) obj) == 0;

        return false;
    }
}
