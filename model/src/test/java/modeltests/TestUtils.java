package modeltests;

import model.Delegate;
import model.Intervention;
import model.InterventionType;

public class TestUtils {

    public static Intervention createBaseIntervention(InterventionType interventionType) {
        return new Intervention(new Delegate("testUserName", "testFullName", false),
                interventionType);
    }

}
