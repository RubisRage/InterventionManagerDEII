package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AttendantListTest {

    private AttendantList attendantList;
    private Delegate delegate1, delegate2, delegate3, delegate4;
    private MeetingPoint first, second, third, fourth, fifth;

    @BeforeEach
    void setUp(){

        attendantList = new AttendantList();

        delegate1 = new Delegate("delegate1", "fulldelegate1");
        delegate2 = new Delegate("delegate2", "fulldelegate2");
        delegate3 = new Delegate("delegate3", "fulldelegate3");
        delegate4 = new Delegate("delegate4", "fulldelegate4");

        attendantList.addAttendant(delegate1);
        attendantList.addAttendant(delegate2);
        attendantList.addAttendant(delegate3);
        attendantList.addAttendant(delegate4);

        first = new MeetingPoint("first", delegate1);
        second = new MeetingPoint("second", delegate2);
        third = new MeetingPoint("third", delegate2);
        fourth = new MeetingPoint("fourth", delegate3);
        fifth = new MeetingPoint("fifth", delegate4);
    }

    @Test
    void reentryAttendants() {

        attendantList.retireAttendant(delegate1);
        attendantList.retireAttendant(delegate3);

        for(AttendantList.Attendant at : attendantList.getAttendants()){
            if(at.getDelegate().equals(delegate1) || at.getDelegate().equals(delegate3)){
                assertFalse(at.onMeeting());
            } else {
                assertTrue(at.onMeeting());
            }
        }

        attendantList.addAttendant(delegate1);

        for(AttendantList.Attendant at : attendantList.getAttendants()){
            if(at.getDelegate().equals(delegate3)){
                assertFalse(at.onMeeting());
            } else {
                assertTrue(at.onMeeting());
            }
        }
    }

    @Test
    void attendantsValidDatesTest() {
        attendantList = new AttendantList();
        attendantList.addAttendant(delegate1);
        AttendantList.Attendant attendant = attendantList.getAttendants().get(0);

        assertTrue(attendant.onMeeting());
        assertNotNull(attendant.getJoinHour());
        assertNull(attendant.getLeaveHour());

        attendantList.retireAttendant(delegate1);

        assertFalse(attendant.onMeeting());
        assertNotNull(attendant.getJoinHour());
        assertNotNull(attendant.getLeaveHour());
        LocalDateTime last = attendant.getLeaveHour();
        assertTrue(attendant.getJoinHour().compareTo(last) < 0);

        attendantList.addAttendant(delegate1);

        assertTrue(attendant.onMeeting());
        assertNotNull(attendant.getJoinHour());
        assertNull(attendant.getLeaveHour());

        attendantList.retireAttendant(delegate1);
        assertTrue(last.compareTo(attendant.getLeaveHour()) < 0);
    }
}
