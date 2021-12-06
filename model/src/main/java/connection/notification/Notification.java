package connection.notification;

import java.io.Serializable;

public interface Notification extends Serializable {
    void accept(NotificationHandler handler);
}
