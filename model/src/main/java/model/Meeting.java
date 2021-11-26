package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Meeting {
    private final ArrayList<Delegate> participants;
    private final ArrayList<MeetingPoint> meetingPoints;
    private final LocalDate date;

    public Meeting() {
        date = LocalDate.now();
        participants = new ArrayList<>();
        meetingPoints = new ArrayList<>();
    }
}
