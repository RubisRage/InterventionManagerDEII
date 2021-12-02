package connection.request;

public class CreateMeetingRequest implements Request {
    @Override
    public void accept(RequestHandler handler) {
        handler.handleCreateMeetingRequest(this);
    }
}
