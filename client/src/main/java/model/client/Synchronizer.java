package model.client;

import model.Delegate;
import model.Intervention;
import model.Meeting;

public interface Synchronizer {

    void login(String username, String password);
    void logout();
    void createMeeting(Meeting meeting);
    void joinMeeting();
    void notifyPassIntervention();
    void notifyPassMeetingPoint();
    void notifyCreateIntervention(Intervention intervention);
    void notifyCancelIntervention(Intervention intervention);

}
