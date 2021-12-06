package connection.notification;

import model.Intervention;

public record CancelInterventionNotification(Intervention intervention) implements Notification {
    @Override
    public void accept(NotificationHandler handler) {
        handler.handleCancelInterventionNotification(this);
    }
}
