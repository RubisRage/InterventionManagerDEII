package client.control;

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

        ViewManager.getVM().getView().update();
    }

    @Override
    public void handleAbandonMeetingResponse(AbandonMeetingResponse r) {
        if(r.ack()){
            InterventionManager.getIM().setCurrentMeeting(null);
        }

        ViewManager.getVM().getView().update();
    }

    @Override
    public void handleLogoutResponse(LogoutResponse r) {

        ViewManager.getVM().getView().update();
    }

    @Override
    public void handleNextMeetingItemNotification(NextMeetingItemNotification r) {
        InterventionManager.getIM().getCurrentMeeting().nextMeetingItem();
        ViewManager.getVM().getView().update();
    }

    @Override
    public void handlePrevMeetingItemNotification(PrevMeetingItemNotification r) {
        InterventionManager.getIM().getCurrentMeeting().previousMeetingItem();
        ViewManager.getVM().getView().update();
    }

    @Override
    public void handleCreateInterventionNotification(CreateInterventionNotification r) {
        InterventionManager.getIM().getCurrentMeeting().getCurrentMeetingItem().addIntervention(r.intervention());

        ViewManager.getVM().getView().update();
    }

    @Override
    public void handleCancelInterventionNotification(CancelInterventionNotification r) {
        InterventionManager.getIM().getCurrentMeeting().getCurrentMeetingItem().cancelIntervention(r.intervention());

        ViewManager.getVM().getView().update();
    }
}
