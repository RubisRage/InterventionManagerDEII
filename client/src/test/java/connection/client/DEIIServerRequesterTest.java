package connection.client;

import connection.request.CreateInterventionRequest;
import model.InterventionType;
import model.TestUtils;
import connection.request.AuthRequest;
import connection.request.CreateMeetingRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class DEIIServerRequesterTest {

    private ObjectInputStream objReader;
    private DEIIServerRequester sr;

    @BeforeEach
    void setUp() throws IOException {
        PipedInputStream reader;
        sr = new DEIIServerRequester(new PipedOutputStream((reader = new PipedInputStream())));

        objReader = new ObjectInputStream(reader);
    }

    @Test
    void sendSimpleRequestTest() throws ClassNotFoundException, IOException, InterruptedException{
        sr.start();

        AuthRequest r1, r2, r3, r4;

        sr.sendRequest(r1 = new AuthRequest("user1", "pass1"));
        sr.sendRequest(r2 = new AuthRequest("user2", "pass2"));
        sr.sendRequest(r3 = new AuthRequest("user3", "pass3"));
        sr.sendRequest(r4 = new AuthRequest("user4", "pass4"));

        assertEquals(objReader.readObject(), r1);
        assertEquals(objReader.readObject(), r2);
        assertEquals(objReader.readObject(), r3);
        assertEquals(objReader.readObject(), r4);

        sr.disconnect();
        TimeUnit.MILLISECONDS.sleep(2*DEIIServerRequester.QUERY_TIMEOUT);

        assertFalse(sr.isAlive());
    }

    @Test
    void sendComplexRequestTest() throws InterruptedException, IOException, ClassNotFoundException {
        sr.start();

        CreateMeetingRequest r1, r2, r3, r4;
        CreateInterventionRequest r5, r6;

        sr.sendRequest(r1 = new CreateMeetingRequest(TestUtils.createBaseMeeting("test1.")));
        sr.sendRequest(r2 = new CreateMeetingRequest(TestUtils.createBaseMeeting("test2.")));
        sr.sendRequest(r3 = new CreateMeetingRequest(TestUtils.createBaseMeeting("test3.")));
        sr.sendRequest(r4 = new CreateMeetingRequest(TestUtils.createBaseMeeting("test4.")));
        sr.sendRequest(r5 = new CreateInterventionRequest(TestUtils.createBaseIntervention(InterventionType.DIRECT_INTERVENTION)));
        sr.sendRequest(r6 = new CreateInterventionRequest(TestUtils.createBaseIntervention(InterventionType.INFORMATION_POINT)));

        assertEquals(objReader.readObject(), r1);
        assertEquals(objReader.readObject(), r2);
        assertEquals(objReader.readObject(), r3);
        assertEquals(objReader.readObject(), r4);
        assertEquals(objReader.readObject(), r5);
        assertEquals(objReader.readObject(), r6);

        sr.disconnect();
        TimeUnit.MILLISECONDS.sleep(2*DEIIServerRequester.QUERY_TIMEOUT);

        assertFalse(sr.isAlive());
    }
}