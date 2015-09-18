package mx.uach.fing.almaceneshwrace.handlers.payloads;

import java.util.Map;
import mx.uach.fing.almaceneshwrace.handlers.Validable;

/**
 *
 * @author Jonathan
 */
public class LoginPayload implements Validable {

    Map <String, String> data;
    String email;
    String password;

    public LoginPayload() {
    }

    @Override
    public void fillObject(Map<String, String[]> formData) {
        //Si el formulario se envia vacio, el valor sera una cadena vacia, no nulo
        email = ("".equals(formData.get("email")[0])) ? 
                null : formData.get("email")[0];
        password = ("".equals(formData.get("password")[0])) ? 
                null : formData.get("password")[0];
        data.put("email", email);
        data.put("password", password);
    }

    @Override
    public boolean isValid() {
        if(email == null || password == null){
            return false;
        }
        return true;
    }

    @Override
    public Object getData() {
        return data;
    }

}
