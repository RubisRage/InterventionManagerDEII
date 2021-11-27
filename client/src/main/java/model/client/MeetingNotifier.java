package model.client;

import model.Intervention;

public interface MeetingNotifier {

    void notifyPassIntervention();
    void notifyPassMeetingPoint();
    void notifyCreateIntervention(Intervention intervention);
    void notifyCancelIntervention(Intervention intervention);

}
