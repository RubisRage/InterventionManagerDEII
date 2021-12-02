package connection.notification;

public abstract class Response implements Notification {
    private final Boolean ack;

    public Response(Boolean ack){
        this.ack = ack;
    }

    public Boolean ack(){
        return ack;
    }
}
