package connection.request;

public class AbandonMeetingRequest implements Request {
    @Override
    public void accept(RequestHandler handler) {
        handler.handleAbandonMeetingRequest(this);
    }
}
