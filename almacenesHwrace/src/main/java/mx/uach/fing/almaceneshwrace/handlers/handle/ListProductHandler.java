/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uach.fing.almaceneshwrace.handlers.handle;

import java.util.Map;
import mx.uach.fing.almaceneshwrace.handlers.AbstractRequestHandler;
import mx.uach.fing.almaceneshwrace.handlers.Answer;
import mx.uach.fing.almaceneshwrace.handlers.payloads.EmptyPayload;

/**
 *
 * @author jesus
 */
public class ListProductHandler extends AbstractRequestHandler<EmptyPayload> {

    public ListProductHandler(){
        super.payload = new EmptyPayload();
    }
    protected Answer processImpl(EmptyPayload Payload, Map<String, String> queryParams) {
        
    }
}
