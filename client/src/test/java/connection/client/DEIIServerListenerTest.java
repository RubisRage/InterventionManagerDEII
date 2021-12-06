package connection.client;

import client.control.InterventionManager;
import client.gui.LoginView;
import client.gui.ViewManager;
import connection.notification.AuthResponse;
import connection.notification.Notification;
import model.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.channels.Pipe;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DEIIServerListenerTest {

    interface TestRunnable extends Runnable{
        void stop();
    }

    private TestRunnable r;
    private DEIIServerListener sl;
    private ObjectOutputStream objWriter;

    @BeforeEach
    void setUp() throws IOException {
        PipedInputStream in;
        PipedOutputStream out = new PipedOutputStream(in = new PipedInputStream());

        objWriter = new ObjectOutputStream(out);

        r = new TestRunnable() {
            private Boolean running = true;

            public synchronized Boolean isRunning(){
                return running;
            }

            public synchronized void stop(){
                running = false;
                sl.disconnect();
            }

            @Override
            public void run(){

                while(isRunning()) {
                    try {
                        sl = new DEIIServerListener(in);
                        sl.run();
                    } catch (Exception ignored) {

                    }
                }
            }
        };
    }

    @Test
    void simpleNotificationTest() throws IOException, InterruptedException{
        new Thread(r).start();

        AuthResponse n1;

        objWriter.writeObject(n1 = new AuthResponse(true, TestUtils.createBaseDelegate("testname")));

        while(InterventionManager.getIM().getUser() == null) Thread.sleep(1000);
        assertEquals(n1.getUser(), InterventionManager.getIM().getUser());

        r.stop();
    }
}
