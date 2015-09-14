package mx.uach.fing.almaceneshwrace.handlers;

/**
 * This class is the envelope to compose the response, using an HTTP code
 * and the body for the response
 * Created Sept 12 2015 @ 09:17 AM
 * @author Jonathan
 */

public class Answer {
    
    private int code;
    private String body;
    
    public Answer(int code, String body){
        this.code = code;
        this.body = body;
    }
    
    public Answer(int code){
        this.code = code;
    }

    /**
     * Method to get the body of the response to output
     * @return String
     */
    public String getBody() {
        return body;
    }

    /**
     * Method to get the HTTP Response code for the processed request
     * @return Integer
     */
    public int getCode() {
        return code;
    }

    /**
     * Method to make the response and output it
     * @param body
     * @return Answer
     */
    public static Answer ok(String body) {
        return new Answer(200, body);
    }
    
    @Override
    public String toString() {
        return "Answer(code=" + code + ", body=" + body + ")";
    }
}
