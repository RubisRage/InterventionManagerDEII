package modeltests;

import model.Delegate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Intervention;
import model.InterventionType;

import static org.junit.jupiter.api.Assertions.*;

public class InterventionTest {

    private Intervention directIntervention, joke, question, technicalNote, informationPoint;

    @BeforeEach
    public void setUp(){
         directIntervention = TestUtils.createBaseIntervention(InterventionType.DIRECT_INTERVENTION);
         joke = TestUtils.createBaseIntervention(InterventionType.JOKE);
         question = TestUtils.createBaseIntervention(InterventionType.QUESTION_OR_NEW_TOPIC);
         technicalNote = TestUtils.createBaseIntervention(InterventionType.TECHNICAL_NOTE);
         informationPoint = TestUtils.createBaseIntervention(InterventionType.INFORMATION_POINT);
    }

    @Test
    public void comparingByPriorityTest() {
        assertTrue(technicalNote.compareTo(informationPoint) < 0);
        assertTrue(informationPoint.compareTo(directIntervention) < 0);
        assertTrue(directIntervention.compareTo(question) < 0);
        assertTrue(question.compareTo(joke) < 0);

        assertEquals(0, technicalNote.compareTo(technicalNote));
    }

    @Test
    public void comparingByTimestampTest(){
        Intervention directInterventionLater = TestUtils.createBaseIntervention(InterventionType.DIRECT_INTERVENTION);
        assertTrue(directIntervention.compareTo(directInterventionLater) < 0);
    }

    @Test
    public void equalsTest(){
        assertEquals(directIntervention, directIntervention);
        assertEquals(joke, joke);
        assertNotEquals(joke, directIntervention);
        assertNotEquals(question, technicalNote);
    }
}
