package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class Meeting implements Serializable {
    private final LinkedHashSet<MeetingItem> meetingItems;
    private final LocalDate date;


    private final AttendantList attendantList;
    private Integer currentMeetingItemIndex;

    public Meeting() {
        date = LocalDate.now();
        meetingItems = new LinkedHashSet<>();
        currentMeetingItemIndex = 0;
        attendantList = new AttendantList();
    }

    public void addMeetingItem(MeetingItem meetingItem){
        meetingItems.add(meetingItem);
    }

    public MeetingItem getCurrentMeetingItem(){
        return (MeetingItem) meetingItems.toArray()[currentMeetingItemIndex];
    }

    public void nextMeetingItem(){
        if(hasNextMeetingItem()){
            currentMeetingItemIndex++;
        }
    }

    public Boolean hasNextMeetingItem(){
        return currentMeetingItemIndex < meetingItems.size() - 1 ;
    }

    public void previousMeetingItem(){
        if(hasPreviousMeetingItem()){
            currentMeetingItemIndex--;
        }
    }

    public Boolean hasPreviousMeetingItem(){
        return currentMeetingItemIndex > 0;
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
                    && this.meetingItems.equals(other.meetingItems)
                    && this.attendantList.equals(other.attendantList);
        }

        return false;
    }
}
