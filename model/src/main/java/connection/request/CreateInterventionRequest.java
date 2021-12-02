package connection.request;

import model.Intervention;

public record CreateInterventionRequest(Intervention intervention) implements Request {
    @Override
    public void accept(RequestHandler handler) {
        handler.handleCreateInterventionRequest(this);
    }
}
