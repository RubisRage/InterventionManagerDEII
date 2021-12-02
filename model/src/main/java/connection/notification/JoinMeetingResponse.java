package connection.notification;

import model.Meeting;

public class JoinMeetingResponse extends Response {
    private Meeting meeting;

    public JoinMeetingResponse(Boolean ack, Meeting meeting) {
        super(ack);
        this.meeting = meeting;
    }

    @Override
    public void accept(NotificationHandler handler) {
        handler.handleJoinMeetingResponse(this);
    }

    public Meeting getMeeting() {
        return meeting;
    }
}
