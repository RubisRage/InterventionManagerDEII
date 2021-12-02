package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class Meeting implements Serializable {
    private final LinkedHashSet<MeetingPoint> meetingPoints;
    private final LocalDate date;


    private final AttendantList attendantList;
    private Integer currentMeetingPointIndex;

    public Meeting() {
        date = LocalDate.now();
        meetingPoints = new LinkedHashSet<>();
        currentMeetingPointIndex = 0;
        attendantList = new AttendantList();
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

    public LocalDate getDate() {
        return date;
    }

    public AttendantList getAttendantList() {
        return attendantList;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Meeting other){
            return this.date.equals(other.date)
                    && this.meetingPoints.equals(other.meetingPoints)
                    && this.attendantList.equals(other.attendantList);
        }

        return false;
    }
}
