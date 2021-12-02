package connection.notification;

public class CreateInterventionNotification implements Notification {
    @Override
    public void accept(NotificationHandler handler) {
        handler.handleCreateIntervetionNotification(this);
    }
}
