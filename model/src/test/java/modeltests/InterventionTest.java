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
         directIntervention = new Intervention(new Delegate(), InterventionType.DIRECT_INTERVENTION);
         joke = new Intervention(new Delegate(), InterventionType.JOKE);
         question = new Intervention(new Delegate(), InterventionType.QUESTION_OR_NEW_TOPIC);
         technicalNote = new Intervention(new Delegate(), InterventionType.TECHNICAL_NOTE);
         informationPoint = new Intervention(new Delegate(), InterventionType.INFORMATION_POINT);
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
        Intervention directInterventionLater = new Intervention(new Delegate(), InterventionType.DIRECT_INTERVENTION);
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
