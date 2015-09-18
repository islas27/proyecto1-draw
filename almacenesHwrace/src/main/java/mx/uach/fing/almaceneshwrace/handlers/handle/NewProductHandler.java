package mx.uach.fing.almaceneshwrace.handlers.handle;

import java.util.Map;
import mx.uach.fing.almaceneshwrace.handlers.AbstractRequestHandler;
import mx.uach.fing.almaceneshwrace.handlers.Answer;
import mx.uach.fing.almaceneshwrace.handlers.payloads.NewProductPayload;
import mx.uach.fing.almaceneshwrace.models.Product;

/**
 *
 * @author Jesus
 */
public class NewProductHandler extends AbstractRequestHandler<NewProductPayload> {
    
    public NewProductHandler() {
    	 payload = new NewProductPayload()
    }

    @Override
    protected Answer processImpl(NewProductPayload value, Map<String, String> queryParams) {
        Product p = (Product)this.payload.getData();
        p.create();
        return Answer.ok("ok");
    }
}