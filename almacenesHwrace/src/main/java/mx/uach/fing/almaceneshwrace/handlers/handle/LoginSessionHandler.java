/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uach.fing.almaceneshwrace.handlers.handle;

import java.util.Date;
import java.util.List;
import java.util.Map;
import mx.uach.fing.almaceneshwrace.handlers.AbstractRequestHandler;
import mx.uach.fing.almaceneshwrace.handlers.Answer;
import mx.uach.fing.almaceneshwrace.handlers.payloads.LoginPayload;
import mx.uach.fing.almaceneshwrace.models.User;

/**
 *
 * @author Jonathan
 */
public class LoginSessionHandler extends AbstractRequestHandler<LoginPayload> {
    
    List<User> lu;
    User u;

    public LoginSessionHandler() {
        payload = new LoginPayload();
    }

    @Override
    protected Answer processImpl(LoginPayload Payload, Map<String, String> queryParams) {
        Map<String, String> data = (Map<String, String>) payload.getData();
        lu = User.findByEmail(data.get("email"));
        System.out.println("Size of lu: " + lu.size());
        if (lu.size() > 0) {
            System.out.println("Entrada 1");
            u = lu.get(0);
            System.out.println("User obtenido: " + u.getEmail() + " pass: " + u.getPassword());
            System.out.println("PASS ingresada en el form: " + data.get("password"));
            if (u.getPassword().equals(data.get("password"))) {
                System.out.println("Entrada 2");
                s.attribute("user", u.getEmail());
                s.attribute("login", true);
                s.attribute("date_login", new Date());
                System.out.println(
                        String.format("User %s logged in at date: %s /n",
                                u.getEmail(), s.attribute("date_login")));
                r.redirect((u.getIsAdmin()) ? "/admin/orderList" : "/clients/shoppingOrder/");
                return new Answer(303);
            }            
        }
        r.redirect("/login/01");
        return new Answer(303);
    }

}
