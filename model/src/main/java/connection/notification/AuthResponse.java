package connection.notification;

import model.Delegate;

public class AuthResponse extends Response {
    private Delegate user;

    public AuthResponse(Boolean ack, Delegate user) {
        super(ack);
        this.user = user;
    }

    public Delegate getUser() {
        return user;
    }

    @Override
    public void accept(NotificationHandler handler) {
        handler.handleAuthResponse(this);
    }
}
