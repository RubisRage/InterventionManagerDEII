package connection.notification;

public class CancelInterventionNotification implements Notification {
    @Override
    public void accept(NotificationHandler handler) {
        handler.handleCancelIntervetionNotification(this);
    }
}
