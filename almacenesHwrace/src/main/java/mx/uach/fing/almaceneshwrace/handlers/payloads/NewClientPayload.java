package mx.uach.fing.almaceneshwrace.handlers.payloads;

import java.util.Map;
import java.util.Set;
import mx.uach.fing.almaceneshwrace.handlers.Validable;
import mx.uach.fing.almaceneshwrace.models.User;

/**
 * This class is in charge of validating the form data received for a 
 * new Client that initiated the registration and then fill the object 
 * so it can be manipulated
 * Created Sept 16 2015 @ 9:28 PM
 * @author Jonathan
 * @version 1.0
 */
public class NewClientPayload implements Validable{
    
    User client;
    
    public NewClientPayload() {
    }

    /**
     * Method to validate the payload received (The form data)
     * @return boolean for the validated payload received
     */
    @Override
    public void fillObject(Set<String> formData) {
        client = new User();
        client.setEmail(null);
    }

    /**
     * Method to fill the User Object with the payload received
     * @param formData as a Set<String> from the Spark.Request
     */
    @Override
    public boolean isValid() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
