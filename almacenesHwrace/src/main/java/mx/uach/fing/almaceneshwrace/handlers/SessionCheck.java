/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uach.fing.almaceneshwrace.handlers;

import java.util.Date;
import spark.Request;
import spark.Session;

/**
 *
 * @author Jonathan
 */
public final class SessionCheck {

    public SessionCheck() {
    }
    
    public static boolean isClientLoggedIn(Request r){
        Session s = r.session(true);
        if(s.isNew()) return false;
        boolean logged = s.attribute("login");
        boolean isAdmin = s.attribute("type");
        Date date = s.attribute("date_login");
        Date date_expiration = s.attribute("date_expiration");
        if(logged == true && date.before(date_expiration) && !isAdmin){
            s.attribute("date_login", new Date());
            return true;
        }else{
            s.attribute("login", false);
        }
        return false;
    }
    
    public static boolean isAdminLoggedIn(Request r){
        Session s = r.session(true);
        if(s.isNew()) return false;
        boolean logged = s.attribute("login");
        boolean isAdmin = s.attribute("type");
        Date date = s.attribute("date_login");
        Date date_expiration = s.attribute("date_expiration");
        if(logged == true && date.before(date_expiration) && isAdmin){
            s.attribute("date_login", new Date());
            return true;
        }else{
            s.attribute("login", false);
        }
        return false;
    }
    
}
