package connection.request;

import model.Meeting;

public record CreateMeetingRequest(Meeting meeting) implements Request {

    @Override
    public void accept(RequestHandler handler) {
        handler.handleCreateMeetingRequest(this);
    }
}
