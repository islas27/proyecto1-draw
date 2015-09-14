package mx.uach.fing.almaceneshwrace.handlers.handle;

import java.util.Map;
import mx.uach.fing.almaceneshwrace.dao.Crud;
import mx.uach.fing.almaceneshwrace.handlers.AbstractRequestHandler;
import mx.uach.fing.almaceneshwrace.handlers.Answer;
import mx.uach.fing.almaceneshwrace.handlers.payloads.NewProductPayload;

/**
 *
 * @author Jonathan
 */
public class NewProductHandler extends AbstractRequestHandler<NewProductPayload> {
    
    public NewProductHandler(Crud dao) {
        //We asign the DAO to use in accordance to the model to work with
        super(dao);
    }

    @Override
    protected Answer processImpl(NewProductPayload value, Map<String, String> queryParams) {
        //Here we do the actual process of the petition, if the payload
        //is valid, else, we return another response.
        c.create(value);
        return Answer.ok("Body to give to the response");
    }
}