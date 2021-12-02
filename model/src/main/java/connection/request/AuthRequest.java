package connection.request;

public class AuthRequest implements Request{
    @Override
    public void accept(RequestHandler handler) {
        handler.handleAuthRequest(this);
    }
}
