package mx.uach.fing.almaceneshwrace.handlers.handle;

import java.util.Map;
import mx.uach.fing.almaceneshwrace.handlers.AbstractRequestHandler;
import mx.uach.fing.almaceneshwrace.handlers.Answer;
import mx.uach.fing.almaceneshwrace.handlers.payloads.EmptyPayload;

/**
 *
 * @author Jonathan
 */
public class LoginPageHandler extends AbstractRequestHandler<EmptyPayload>{

    public LoginPageHandler() {
        super.payload = new EmptyPayload();
    }

    @Override
    protected Answer processImpl(EmptyPayload Payload, Map<String, String> queryParams) {
        //Temp, while we implement error codes
        r.redirect("/login.html", 300);
        return new Answer(200);
    }
    
}
