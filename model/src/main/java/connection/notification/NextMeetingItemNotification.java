package connection.notification;

public class NextMeetingItemNotification implements Notification {
    @Override
    public void accept(NotificationHandler handler) {
        handler.handleNextMeetingItemNotification(this);
    }
}
