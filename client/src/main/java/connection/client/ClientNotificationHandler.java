package connection.client;

import client.control.InterventionManager;
import client.gui.ViewManager;
import connection.notification.*;

public class ClientNotificationHandler implements NotificationHandler {
    @Override
    public void handleAuthResponse(AuthResponse r) {
        if(r.ack()){
            InterventionManager.getIM().setUser(r.getUser());
        }

        ViewManager.getVM().getView().update();
    }

    @Override
    public void handleJoinMeetingResponse(JoinMeetingResponse r) {
        if(r.ack()){
            InterventionManager.getIM().setCurrentMeeting(r.getMeeting());
        }
    }

    @Override
    public void handleAbandonMeetingResponse(AbandonMeetingResponse r) {

    }

    @Override
    public void handleLogoutResponse(LogoutResponse r) {

    }

    @Override
    public void handleNextMeetingItemNotification(NextMeetingItemNotification r) {

    }

    @Override
    public void handlePrevMeetingItemNotification(PrevMeetingItemNotification r) {

    }

    @Override
    public void handleCreateIntervetionNotification(CreateInterventionNotification r) {

    }

    @Override
    public void handleCancelIntervetionNotification(CancelInterventionNotification r) {

    }
}
