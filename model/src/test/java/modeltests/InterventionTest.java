package modeltests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import model.Intervention;
import model.InterventionType;

public class InterventionTest {

    @Test
    public void comparingByTypeTest() {
        Intervention directResponse = new Intervention(InterventionType.DIRECT_RESPONSE);
        Intervention joke = new Intervention(InterventionType.JOKE);

        assertTrue(directResponse.compareTo(joke) > 0);
    }

    @Test
    public void comparingByTimestampTest(){
        Intervention first = new Intervention(InterventionType.INFORMATION_POINT);
        Intervention second = new Intervention(InterventionType.INFORMATION_POINT);

        assertTrue(first.compareTo(second) < 0);
    }
}
