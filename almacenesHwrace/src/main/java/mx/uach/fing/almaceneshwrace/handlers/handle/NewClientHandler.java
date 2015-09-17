package mx.uach.fing.almaceneshwrace.handlers.handle;

import java.util.Map;
import mx.uach.fing.almaceneshwrace.handlers.AbstractRequestHandler;
import mx.uach.fing.almaceneshwrace.handlers.Answer;
import mx.uach.fing.almaceneshwrace.handlers.payloads.NewClientPayload;

/**
 *
 * @author Jonathan
 */
public class NewClientHandler extends AbstractRequestHandler<NewClientPayload>{

    @Override
    protected Answer processImpl(NewClientPayload Payload, Map<String, String> queryParams) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
