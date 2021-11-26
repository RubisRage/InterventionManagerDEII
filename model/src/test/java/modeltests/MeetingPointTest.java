package modeltests;

import model.Delegate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Intervention;
import model.InterventionType;

import static org.junit.jupiter.api.Assertions.*;

public class MeetingPointTest {

    private Intervention createBaseIntervention(InterventionType interventionType){
        return new Intervention(new Delegate("testUserName", "testFullName"), interventionType);
    }

    @BeforeEach
    void setUp(){

    }
}
