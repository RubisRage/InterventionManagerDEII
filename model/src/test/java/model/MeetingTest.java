package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MeetingTest {

    private Meeting meeting;
    private MeetingItem first, second, third, fourth, fifth;

    @BeforeEach
    void setUp(){
        meeting = new Meeting();

        Delegate delegate1 = new Delegate("delegate1", "fulldelegate1");
        Delegate delegate2 = new Delegate("delegate2", "fulldelegate2");
        Delegate delegate3 = new Delegate("delegate3", "fulldelegate3");
        Delegate delegate4 = new Delegate("delegate4", "fulldelegate4");

        first = new MeetingItem("first", delegate1);
        second = new MeetingItem("second", delegate2);
        third = new MeetingItem("third", delegate2);
        fourth = new MeetingItem("fourth", delegate3);
        fifth = new MeetingItem("fifth", delegate4);

        meeting.addMeetingItem(first);
        meeting.addMeetingItem(second);
        meeting.addMeetingItem(third);
        meeting.addMeetingItem(fourth);
        meeting.addMeetingItem(fifth);
    }

    @Test
    void meetingWithNoRegressionTest() {
        assertTrue(meeting.hasNextMeetingItem());
        assertFalse(meeting.hasPreviousMeetingItem());
        assertEquals(meeting.getCurrentMeetingItem(), first);

        meeting.nextMeetingItem();

        assertTrue(meeting.hasNextMeetingItem());
        assertTrue(meeting.hasPreviousMeetingItem());
        assertEquals(meeting.getCurrentMeetingItem(), second);

        meeting.nextMeetingItem();
        meeting.nextMeetingItem();
        meeting.nextMeetingItem();

        assertFalse(meeting.hasNextMeetingItem());
        assertTrue(meeting.hasPreviousMeetingItem());
        assertEquals(meeting.getCurrentMeetingItem(), fifth);
    }

    @Test
    void meetingWithRegressionsTest() {
        meeting.nextMeetingItem();
        meeting.nextMeetingItem();
        meeting.nextMeetingItem();

        assertEquals(meeting.getCurrentMeetingItem(), fourth);
        assertTrue(meeting.hasNextMeetingItem());
        assertTrue(meeting.hasPreviousMeetingItem());

        meeting.previousMeetingItem();

        assertEquals(meeting.getCurrentMeetingItem(), third);
        assertTrue(meeting.hasNextMeetingItem());
        assertTrue(meeting.hasPreviousMeetingItem());

        meeting.previousMeetingItem();
        meeting.previousMeetingItem();

        assertEquals(meeting.getCurrentMeetingItem(), first);
        assertTrue(meeting.hasNextMeetingItem());
        assertFalse(meeting.hasPreviousMeetingItem());
    }
}
