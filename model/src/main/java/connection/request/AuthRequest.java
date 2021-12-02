package connection.request;

public record AuthRequest(String username, String encryptedPassword) implements Request {

    @Override
    public void accept(RequestHandler handler) {
        handler.handleAuthRequest(this);
    }
}
