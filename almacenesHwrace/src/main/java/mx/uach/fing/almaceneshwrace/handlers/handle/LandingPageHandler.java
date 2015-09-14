package mx.uach.fing.almaceneshwrace.handlers.handle;

import java.util.Map;
import mx.uach.fing.almaceneshwrace.dao.Crud;
import mx.uach.fing.almaceneshwrace.handlers.AbstractRequestHandler;
import mx.uach.fing.almaceneshwrace.handlers.Answer;
import mx.uach.fing.almaceneshwrace.handlers.payloads.EmptyPayload;

/**
 *
 * @author Jonathan
 */
public class LandingPageHandler extends AbstractRequestHandler<EmptyPayload> {
    
    public LandingPageHandler(Crud dao) {
        super(dao);
        super.payload = new EmptyPayload();
    }

    @Override
    protected Answer processImpl(EmptyPayload Payload, Map<String, String> queryParams) {
        return Answer.ok("Body to give to the response");
    }
}