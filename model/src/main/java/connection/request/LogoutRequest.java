package connection.request;

public class LogoutRequest implements Request {
    @Override
    public void accept(RequestHandler handler) {
        handler.handleLogoutRequest(this);
    }
}
