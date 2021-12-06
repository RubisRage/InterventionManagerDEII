package connection.notification;

public interface NotificationHandler {
    void handleAuthResponse(AuthResponse r);
    void handleJoinMeetingResponse(JoinMeetingResponse r);
    void handleAbandonMeetingResponse(AbandonMeetingResponse r);
    void handleLogoutResponse(LogoutResponse r);
    void handleNextMeetingItemNotification(NextMeetingItemNotification r);
    void handlePrevMeetingItemNotification(PrevMeetingItemNotification r);
    void handleCreateInterventionNotification(CreateInterventionNotification r);
    void handleCancelInterventionNotification(CancelInterventionNotification r);
}
