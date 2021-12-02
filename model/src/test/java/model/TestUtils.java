package model;

public class TestUtils {

    public static Intervention createBaseIntervention(InterventionType interventionType) {
        return new Intervention(new Delegate("testUserName", "testFullName", false),
                interventionType);
    }

    public static Delegate createBaseDelegate(String testString){
        return new Delegate(testString, testString);
    }

    public static Meeting createBaseMeeting(String testString){
        Meeting meeting = new Meeting();

        for(int i = 0; i < 4; i++)
            meeting.addMeetingPoint(new MeetingPoint(testString+i, createBaseDelegate(testString+i)));

        for(int i = 0; i < 4; i++)
            meeting.getAttendantList().addAttendant(createBaseDelegate(testString+i));

        return meeting;
    }
}
