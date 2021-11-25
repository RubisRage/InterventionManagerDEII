package model;

import java.time.LocalDateTime;

public class Intervention implements Comparable<Intervention>{
    private final InterventionType type;
    private final LocalDateTime timestamp;

    public Intervention(InterventionType type)
    {
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
}
