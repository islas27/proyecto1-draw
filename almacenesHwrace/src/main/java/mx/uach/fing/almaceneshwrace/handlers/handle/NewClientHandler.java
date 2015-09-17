package mx.uach.fing.almaceneshwrace.handlers.handle;

import java.util.Map;
import mx.uach.fing.almaceneshwrace.handlers.AbstractRequestHandler;
import mx.uach.fing.almaceneshwrace.handlers.Answer;
import mx.uach.fing.almaceneshwrace.handlers.payloads.NewClientPayload;
import mx.uach.fing.almaceneshwrace.models.User;

/**
 *
 * @author Jonathan
 */
public class NewClientHandler extends AbstractRequestHandler<NewClientPayload>{

    public NewClientHandler() {
        payload = new NewClientPayload();
    }

    @Override
    protected Answer processImpl(NewClientPayload Payload, Map<String, String> queryParams) {
        User c = (User) this.payload.getData();
        c.create();
        return new Answer(200, "ok");
    }
    
}
