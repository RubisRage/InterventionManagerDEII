package connection.notification;

public class LogoutResponse extends Response {
    public LogoutResponse(Boolean ack) {
        super(ack);
    }

    @Override
    public void accept(NotificationHandler handler) {
        handler.handleLogoutResponse(this);
    }
}
