package connection.request;

public class JoinMeetingRequest implements Request {
    @Override
    public void accept(RequestHandler handler) {
        handler.handleJoinMeetingRequest(this);
    }
}
