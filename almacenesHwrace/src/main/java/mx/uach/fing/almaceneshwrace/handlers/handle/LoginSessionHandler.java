/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uach.fing.almaceneshwrace.handlers.handle;

import java.util.Map;
import mx.uach.fing.almaceneshwrace.handlers.AbstractRequestHandler;
import mx.uach.fing.almaceneshwrace.handlers.Answer;
import mx.uach.fing.almaceneshwrace.handlers.payloads.LoginPayload;
import mx.uach.fing.almaceneshwrace.models.User;

/**
 *
 * @author Jonathan
 */
public class LoginSessionHandler extends AbstractRequestHandler<LoginPayload>{

    @Override
    protected Answer processImpl(LoginPayload Payload, Map<String, String> queryParams) {
        return new Answer(200, "ok");
    }
    
}
