package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AttendantList {

    private final Map<String, Attendant> attendants;

    public AttendantList(){
        attendants = new HashMap<>();
    }

    public void addAttendant(Delegate delegate){
        if(attendants.containsKey(delegate.getUsername())){
            Attendant attendant = attendants.get(delegate.getUsername());

            attendant.onMeeting = true;
            attendant.leaveHour = null;
        } else {
            attendants.put(delegate.getUsername(), new Attendant(delegate));
        }
    }

    public void retireAttendant(Delegate delegate){
        if(attendants.containsKey(delegate.getUsername())){
            Attendant attendant = attendants.get(delegate.getUsername());

            if(attendant.onMeeting){
                attendant.onMeeting = false;
                attendant.leaveHour = LocalDateTime.now();
            }
        }
    }

    public List<Attendant> getAttendants(){
        return new ArrayList<Attendant>(attendants.values());
    }

    public static class Attendant {
        private final LocalDateTime joinHour;
        private LocalDateTime leaveHour;
        private final Delegate delegate;
        private Boolean onMeeting;

        public Attendant(Delegate attendant){
            this.delegate = attendant;
            joinHour = LocalDateTime.now();
            onMeeting = true;
        }

        public LocalDateTime getJoinHour() {
            return joinHour;
        }

        public Boolean onMeeting() {
            return onMeeting;
        }

        public LocalDateTime getLeaveHour() {
            return leaveHour;
        }

        public Delegate getDelegate() {
            return delegate;
        }

        @Override
        public boolean equals(Object obj){
            if(obj instanceof Attendant other){
                return this.delegate.equals(other.delegate);
            }

            return false;
        }
    }
}
