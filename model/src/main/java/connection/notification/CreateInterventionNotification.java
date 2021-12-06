package connection.notification;

import model.Intervention;

public record CreateInterventionNotification(Intervention intervention) implements Notification {
    @Override
    public void accept(NotificationHandler handler) {
        handler.handleCreateInterventionNotification(this);
    }
}
