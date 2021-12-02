package connection.request;

public interface Request {

    void accept(RequestHandler handler);

}
