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
        return !(product.getName() == null || product.getDescription() == null
                                           || product.getCategory() == null
                                           || product.getNumberOfStock() == null
                                           || product.getPrice() == null);
    }

    /**
     * Method to fill the Product Object with the payload received
     * @param formData as a Set<String> from the Spark.Request
     */
    @Override
    public void fillObject(Map<String, String[]> formData) {
        product.setName(formData.get("name").[0]);
        product.setDescription(formData.get("description").[0]);
        product.setCategory(formData.get("category").[0]);
        product.setNumberOfStock(formData.get("numberOfStock").[0]);
        product.setPrice(formData.get("price").[0]);
    }

    @Override
    public Object getData() {
        return This.product;
    }

    
    
}
