package connection.request;

public class NextMeetingItemRequest implements Request {
    @Override
    public void accept(RequestHandler handler) {
        handler.handleNextMeetingItemRequest(this);
    }
}
