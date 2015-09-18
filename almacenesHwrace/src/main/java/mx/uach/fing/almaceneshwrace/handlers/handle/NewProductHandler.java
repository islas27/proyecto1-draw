package mx.uach.fing.almaceneshwrace.handlers.handle;

import java.util.Map;
import mx.uach.fing.almaceneshwrace.handlers.AbstractRequestHandler;
import mx.uach.fing.almaceneshwrace.handlers.Answer;
import mx.uach.fing.almaceneshwrace.handlers.payloads.NewProductPayload;

/**
 *
 * @author Jonathan
 */
public class NewProductHandler extends AbstractRequestHandler<NewProductPayload> {
    
    public NewProductHandler() {
    }

    @Override
    protected Answer processImpl(NewProductPayload value, Map<String, String> queryParams) {
        //Here we do the actual process of the petition, if the payload
        //is valid, else, we return another response.
        return new Answer(200);
    }
}