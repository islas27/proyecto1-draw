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
        if (lu.size() > 0) {
            u = lu.get(0);
            if (u.getPassword().equals(data.get("password"))) {
                Date date = new  Date();
                Date date_expiration = (Date) date.clone();
                date_expiration.setMinutes(date.getMinutes() + 30);
                s.attribute("user", u.getEmail());
                s.attribute("name", u.getName());
                s.attribute("type", u.getIsAdmin());
                s.attribute("uid", u.getId());
                s.attribute("login", true);
                s.attribute("date_login", date);
                s.attribute("date_expiration",date_expiration);
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
