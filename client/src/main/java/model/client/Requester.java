package model.client;

import model.Delegate;
import model.Meeting;

public interface Requester {

    Delegate authenticate(String username, String password);
    Meeting createMeeting(Meeting meeting);
    Meeting joinMeeting();
}
