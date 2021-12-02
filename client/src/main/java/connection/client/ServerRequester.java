package connection.client;

import connection.request.Request;

public interface ServerRequester {
    void sendRequest(Request r);
    void disconnect();
}
