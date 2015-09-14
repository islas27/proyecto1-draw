/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uach.fing.almaceneshwrace.handlers.payloads;

import java.util.Set;
import mx.uach.fing.almaceneshwrace.handlers.Validable;

/**
 *
 * @author Jonathan
 */
public class EmptyPayload implements Validable {

    @Override
    public void fillObject(Set<String> formData) {
        
    }

    @Override
    public boolean isValid() {
        return true;
    }
    
}
