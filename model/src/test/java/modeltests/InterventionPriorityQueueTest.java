package modeltests;


import model.Delegate;
import model.Intervention;
import model.InterventionPriorityQueue;
import model.InterventionType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InterventionPriorityQueueTest {
    private InterventionPriorityQueue queue;
    private Intervention directIntervention, joke, question, technicalNote, informationPoint;

    @BeforeEach
    void setUp() {
        directIntervention = new Intervention(new Delegate("testUserName", "testFullName"),
                InterventionType.DIRECT_INTERVENTION);
        joke = new Intervention(new Delegate("testUserName", "testFullName"),
                InterventionType.JOKE);
        question = new Intervention(new Delegate("testUserName", "testFullName"),
                InterventionType.QUESTION_OR_NEW_TOPIC);
        technicalNote = new Intervention(new Delegate("testUserName", "testFullName"),
                InterventionType.TECHNICAL_NOTE);
        informationPoint = new Intervention(new Delegate("testUserName", "testFullName"),
                InterventionType.INFORMATION_POINT);

        queue = new InterventionPriorityQueue();

        queue.push(directIntervention);
        queue.push(question);
        queue.push(technicalNote);
        queue.push(informationPoint);
        queue.push(joke);
    }

    @Test
    void popOrderWithoutDuplicatesTest() {
        assertEquals(queue.pop(), technicalNote);
        assertEquals(queue.pop(), informationPoint);
        assertEquals(queue.pop(), directIntervention);
        assertEquals(queue.pop(), question);
        assertEquals(queue.pop(), joke);
    }

    @Test
    void popOrderWithDuplicatesTest() {
        Intervention technicalLater = new Intervention(new Delegate("testUserName", "testFullName"),
                InterventionType.TECHNICAL_NOTE);
        Intervention questionLater = new Intervention(new Delegate("testUserName", "testFullName"),
                InterventionType.QUESTION_OR_NEW_TOPIC);

        queue.push(questionLater);
        queue.push(technicalLater);

        assertEquals(queue.pop(), technicalNote);
        assertEquals(queue.pop(), technicalLater);
        assertEquals(queue.pop(), informationPoint);
        assertEquals(queue.pop(), directIntervention);
        assertEquals(queue.pop(), question);
        assertEquals(queue.pop(), questionLater);
        assertEquals(queue.pop(), joke);
    }

    @Test
    void remoteInterventionTest() {
        queue.remove(technicalNote);
        queue.remove(informationPoint);

        assertEquals(queue.pop(), directIntervention);

        Intervention technicalLater = new Intervention(new Delegate("testUserName", "testFullName"),
                InterventionType.TECHNICAL_NOTE);
        queue.push(technicalLater);
        queue.remove(joke);

        assertEquals(queue.pop(), technicalLater);
        assertEquals(queue.pop(), question);
        assertNull(queue.pop());
    }
}
