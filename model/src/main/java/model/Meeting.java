package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class Meeting {
    private final Map<String, Attendant> attendants;
    private final LinkedHashSet<MeetingPoint> meetingPoints;
    private final LocalDate date;
    private Integer currentMeetingPointIndex;

    public Meeting() {
        date = LocalDate.now();
        attendants = new HashMap<>();
        meetingPoints = new LinkedHashSet<>();
        currentMeetingPointIndex = 0;
    }

    public void addMeetingPoint(MeetingPoint meetingPoint){
        meetingPoints.add(meetingPoint);
    }

    public MeetingPoint getCurrentMeetingPoint(){
        return (MeetingPoint) meetingPoints.toArray()[currentMeetingPointIndex];
    }

    public void nextMeetingPoint(){
        if(hasNextMeetingPoint()){
            currentMeetingPointIndex++;
        }
    }

    public Boolean hasNextMeetingPoint(){
        return currentMeetingPointIndex < meetingPoints.size() - 1 ;
    }

    public void previousMeetingPoint(){
        if(hasPreviousMeetingPoint()){
            currentMeetingPointIndex--;
        }
    }

    public Boolean hasPreviousMeetingPoint(){
        return currentMeetingPointIndex > 0;
    }

    public static class Attendant {
        private LocalDateTime in, out;
        private Delegate attendant;
        private Boolean onMeeting;

        public Attendant(Delegate attendant){
            this.attendant = attendant;
            in = LocalDateTime.now();
            onMeeting = true;
        }

        public LocalDateTime getIn() {
            return in;
        }

        public Boolean onMeeting() {
            return onMeeting;
        }

        public LocalDateTime getOut() {
            return out;
        }

        public Delegate getAttendant() {
            return attendant;
        }
    }
}
