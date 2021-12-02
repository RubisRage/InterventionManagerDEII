package connection.request;

import java.io.Serializable;

public interface Request extends Serializable {

    void accept(RequestHandler handler);

}
