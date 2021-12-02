package connection.notification;

public class AbandonMeetingResponse extends Response {
    public AbandonMeetingResponse(Boolean ack) {
        super(ack);
    }

    @Override
    public void accept(NotificationHandler handler) {
       handler.handleAbandonMeetingResponse(this);
    }
}
