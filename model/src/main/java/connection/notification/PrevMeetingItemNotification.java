package connection.notification;

public class PrevMeetingItemNotification implements Notification {
    @Override
    public void accept(NotificationHandler handler) {
        handler.handlePrevMeetingItemNotification(this);
    }
}
