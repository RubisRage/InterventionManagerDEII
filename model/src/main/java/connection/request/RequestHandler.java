package connection.request;

public interface RequestHandler {
    void handleAuthRequest(AuthRequest req);
    void handleJoinMeetingRequest(JoinMeetingRequest req);
    void handleAbandonMeetingRequest(AbandonMeetingRequest req);
    void handleLogoutRequest(LogoutRequest req);
    void handleNextMeetingItemRequest(NextMeetingItemRequest req);
    void handlePrevMeetingItemRequest(PrevMeetingItemRequest req);
    void handleCreateInterventionRequest(CreateInterventionRequest req);
    void handleCancelInterventionRequest(CancelInterventionRequest req);
    void handleCreateMeetingRequest(CreateMeetingRequest req);
}
