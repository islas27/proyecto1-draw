/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uach.fing.almaceneshwrace.handlers.payloads;

import java.util.Map;
import mx.uach.fing.almaceneshwrace.handlers.Validable;
import mx.uach.fing.almaceneshwrace.models.User;

/**
 *
 * @author Jonathan
 */
public class LoginPayload implements Validable {

    User u;
    String email;
    String password;

    public LoginPayload() {
        u = new User();
    }

    @Override
    public void fillObject(Map<String, String[]> formData) {
        //Si el formulario se envia vacio, el valor sera una cadena vacia, no nulo
        email = ("".equals(formData.get("email")[0])) ? 
                null : formData.get("email")[0];
        password = ("".equals(formData.get("password")[0])) ? 
                null : formData.get("password")[0];
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
        return this;
    }

}
