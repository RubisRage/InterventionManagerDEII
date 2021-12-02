package connection.request;

public class PrevMeetingItemRequest implements Request {
    @Override
    public void accept(RequestHandler handler) {
        handler.handlePrevMeetingItemRequest(this);
    }
}
