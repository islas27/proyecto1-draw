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
public class LoginPageHandler extends AbstractRequestHandler<EmptyPayload>{

    public LoginPageHandler(Crud dao) {
        super(dao);
        super.payload = new EmptyPayload();
    }

    @Override
    protected Answer processImpl(EmptyPayload Payload, Map<String, String> queryParams) {
        return Answer.ok("<!DOCTYPE HTML><head><title>Login</title></head><body><form action='/nuevoProducto' method='post'>"+
    "<input type='text' name='nombre'/><input type='text' name='cantidad'/><input type='submit' value='Agregar'/></form></body>");
    }
    
}
