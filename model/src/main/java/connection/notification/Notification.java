package connection.notification;

public interface Notification {
    void accept(NotificationHandler handler);
}
