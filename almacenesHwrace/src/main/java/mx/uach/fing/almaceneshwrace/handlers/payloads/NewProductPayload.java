package mx.uach.fing.almaceneshwrace.handlers.payloads;

import java.util.Map;
import mx.uach.fing.almaceneshwrace.handlers.Validable;
import mx.uach.fing.almaceneshwrace.models.Product;

/**
 * This class is in charge of validating the form data received for a 
 * new Product and then fill the object so it can be manipulated
 * Created Sept 12 2015 @ 12:20 PM
 * @author Jonathan
 * @version 1.0
 */
public class NewProductPayload implements Validable{
    
    Product product = new Product();

    public NewProductPayload(Map<String, String> data) {
        product = new Product();
    }

    /**
     * Method to validate the payload received (The form data)
     * @return boolean for the validated payload received
     */
    @Override
    public boolean isValid() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Method to fill the Product Object with the payload received
     * @param formData as a Set<String> from the Spark.Request
     */
    @Override
    public void fillObject(Map<String, String[]> formData) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
