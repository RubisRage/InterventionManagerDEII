package modeltests;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class MeetingTest {

    private Meeting meeting;
    private MeetingPoint first, second, third, fourth, fifth;

    @BeforeEach
    void setUp(){
        meeting = new Meeting();

        Delegate delegate1 = new Delegate("delegate1", "fulldelegate1");
        Delegate delegate2 = new Delegate("delegate2", "fulldelegate2");
        Delegate delegate3 = new Delegate("delegate3", "fulldelegate3");
        Delegate delegate4 = new Delegate("delegate4", "fulldelegate4");

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
}
