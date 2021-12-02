package connection.request;

public class CancelInterventionRequest implements Request {
    @Override
    public void accept(RequestHandler handler) {
        handler.handleCancelInterventionRequest(this);
    }
}
