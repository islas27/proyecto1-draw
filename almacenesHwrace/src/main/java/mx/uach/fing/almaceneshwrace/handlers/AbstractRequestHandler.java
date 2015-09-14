package mx.uach.fing.almaceneshwrace.handlers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import mx.uach.fing.almaceneshwrace.dao.Crud;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 * This abstract class is from where we'll separate the business logic 
 * from the implementation of spark, so we can do more easily the Unit Test of 
 * each handler.
 * Created Sept 12 2015 @ 09:11 AM
 * @author Jonathan
 * @version 1.0
 */
public abstract class AbstractRequestHandler <V extends Validable> implements Route {

    protected V payload;
    protected Crud c;

    private static final int HTTP_BAD_REQUEST = 400;

    public AbstractRequestHandler(Crud dao){
        this.c = dao;
    }
    
    protected abstract Answer processImpl(V Payload, Map<String, String> queryParams);

    public final Answer process(V payload, Map<String, String> queryParams) {
        if (!payload.isValid()) {
            return new Answer(HTTP_BAD_REQUEST);
        } else {
            return processImpl(payload, queryParams);
        }
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        if(!request.queryParams().isEmpty()){
            payload.fillObject(request.queryParams());
        }
        Map<String, String> queryParams = new HashMap<>();
        Answer answer = process(payload, queryParams);
        response.status(answer.getCode());
        response.type("text/html");
        response.body(answer.getBody());
        return answer.getBody();
    }

}

