package modeltests;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class MeetingTest {

    private Meeting meeting;

    private Delegate delegate1, delegate2, delegate3, delegate4;
    private MeetingPoint first, second, third, fourth, fifth;

    @BeforeEach
    void setUp(){
        meeting = new Meeting();

        delegate1 = new Delegate("delegate1", "fulldelegate1");
        delegate2 = new Delegate("delegate2", "fulldelegate2");
        delegate3 = new Delegate("delegate3", "fulldelegate3");
        delegate4 = new Delegate("delegate4", "fulldelegate4");

        meeting.addAttendant(delegate1);
        meeting.addAttendant(delegate2);
        meeting.addAttendant(delegate3);
        meeting.addAttendant(delegate4);

        first = new MeetingPoint("first", delegate1);
        second = new MeetingPoint("second", delegate2);
        third = new MeetingPoint("third", delegate2);
        fourth = new MeetingPoint("fourth", delegate3);
        fifth = new MeetingPoint("fifth", delegate4);

        meeting.addMeetingPoint(first);
        meeting.addMeetingPoint(second);
        meeting.addMeetingPoint(third);
        meeting.addMeetingPoint(fourth);
        meeting.addMeetingPoint(fifth);
    }

    @Test
    void meetingWithNoRegressionTest() {
        assertTrue(meeting.hasNextMeetingPoint());
        assertFalse(meeting.hasPreviousMeetingPoint());
        assertEquals(meeting.getCurrentMeetingPoint(), first);

        meeting.nextMeetingPoint();

        assertTrue(meeting.hasNextMeetingPoint());
        assertTrue(meeting.hasPreviousMeetingPoint());
        assertEquals(meeting.getCurrentMeetingPoint(), second);

        meeting.nextMeetingPoint();
        meeting.nextMeetingPoint();
        meeting.nextMeetingPoint();

        assertFalse(meeting.hasNextMeetingPoint());
        assertTrue(meeting.hasPreviousMeetingPoint());
        assertEquals(meeting.getCurrentMeetingPoint(), fifth);
    }

    @Test
    void meetingWithRegressionsTest() {
        meeting.nextMeetingPoint();
        meeting.nextMeetingPoint();
        meeting.nextMeetingPoint();

        assertEquals(meeting.getCurrentMeetingPoint(), fourth);
        assertTrue(meeting.hasNextMeetingPoint());
        assertTrue(meeting.hasPreviousMeetingPoint());

        meeting.previousMeetingPoint();

        assertEquals(meeting.getCurrentMeetingPoint(), third);
        assertTrue(meeting.hasNextMeetingPoint());
        assertTrue(meeting.hasPreviousMeetingPoint());

        meeting.previousMeetingPoint();
        meeting.previousMeetingPoint();

        assertEquals(meeting.getCurrentMeetingPoint(), first);
        assertTrue(meeting.hasNextMeetingPoint());
        assertFalse(meeting.hasPreviousMeetingPoint());
    }

    @Test
    void reentryAttendantsTest() {

        meeting.retireAttendant(delegate1);
        meeting.retireAttendant(delegate3);

        for(Meeting.Attendant at : meeting.getAttendants()){
            if(at.getDelegate().equals(delegate1) || at.getDelegate().equals(delegate3)){
                assertFalse(at.onMeeting());
            } else {
                assertTrue(at.onMeeting());
            }
        }

        meeting.addAttendant(delegate1);

        for(Meeting.Attendant at : meeting.getAttendants()){
            if(at.getDelegate().equals(delegate3)){
                assertFalse(at.onMeeting());
            } else {
                assertTrue(at.onMeeting());
            }
        }
    }

    @Test
    void attendantsValidDatesTest() {
        meeting = new Meeting();
        meeting.addAttendant(delegate1);
        Meeting.Attendant attendant = meeting.getAttendants().get(0);

        assertTrue(attendant.onMeeting());
        assertNotNull(attendant.getJoinHour());
        assertNull(attendant.getLeaveHour());

        meeting.retireAttendant(delegate1);

        assertFalse(attendant.onMeeting());
        assertNotNull(attendant.getJoinHour());
        assertNotNull(attendant.getLeaveHour());
        LocalDateTime last = attendant.getLeaveHour();
        assertTrue(attendant.getJoinHour().compareTo(last) < 0);

        meeting.addAttendant(delegate1);

        assertTrue(attendant.onMeeting());
        assertNotNull(attendant.getJoinHour());
        assertNull(attendant.getLeaveHour());

        meeting.retireAttendant(delegate1);
        assertTrue(last.compareTo(attendant.getLeaveHour()) < 0);
    }
}
