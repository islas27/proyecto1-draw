package mx.uach.fing.almaceneshwrace.handlers;

import java.util.Set;

/**
 * This interface is so we can validate the request the client made
 * Created Sept 12 2015 @ 09:14 AM
 * @author Jonathan
 * @version 1.0
 */

public interface Validable {
    void fillObject(Set<String> formData);
    boolean isValid();
}
