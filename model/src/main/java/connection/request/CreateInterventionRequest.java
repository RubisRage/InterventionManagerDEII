package connection.request;

public class CreateInterventionRequest implements Request {
    @Override
    public void accept(RequestHandler handler) {
        handler.handleCreateInterventionRequest(this);
    }
}
