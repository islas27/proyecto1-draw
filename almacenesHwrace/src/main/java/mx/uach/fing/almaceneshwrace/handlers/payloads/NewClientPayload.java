package mx.uach.fing.almaceneshwrace.handlers.payloads;

import java.util.Map;
import mx.uach.fing.almaceneshwrace.handlers.Validable;
import mx.uach.fing.almaceneshwrace.models.User;

/**
 * This class is in charge of validating the form data received for a new Client
 * that initiated the registration and then fill the object so it can be
 * manipulated Created Sept 16 2015 @ 9:28 PM
 *
 * @author Jonathan
 * @version 1.0
 */
public class NewClientPayload implements Validable {

    User client;

    public NewClientPayload() {
        client = new User();
    }

    /**
     * Method to fill the User Object with the payload received
     *
     * @param formData as a Set<String> from the Spark.Request
     */
    @Override
    public void fillObject(Map<String, String[]> formData) {
        client.setEmail(
                (formData.get("email1")[0].equals(formData.get("email2")[0]))
                        ? formData.get("email1")[0] : ""
        );
        client.setPassword(
                (formData.get("pass1")[0].equals(formData.get("pass2")[0]))
                        ? formData.get("pass1")[0] : ""
        );
        client.setName(
                (!formData.get("name")[0].isEmpty())
                        ? formData.get("pass1")[0] : ""
        );
        client.setIsAdmin(false);
    }

    /**
     * Method to validate the object generated
     */
    @Override
    public boolean isValid() {
        if (client.getEmail().isEmpty()
                || client.getName().isEmpty()
                || client.getPassword().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object getData() {
        return this.client;
    }

}
