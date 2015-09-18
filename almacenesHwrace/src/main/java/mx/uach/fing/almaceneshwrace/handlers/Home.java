package mx.uach.fing.almaceneshwrace.handlers;

import java.util.List;
import mx.uach.fing.almaceneshwrace.handlers.handle.*;
import mx.uach.fing.almaceneshwrace.models.Order;
import mx.uach.fing.almaceneshwrace.models.User;
import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.SparkBase.staticFileLocation;

/**
 * Main class of the project. From here spark is going to take control 
 * of the routes of the web application.
 * Created Sept 11  2015 @ 11:38 PM
 * @author Jonathan
 * @version 1.0
 */
public class Home {
    
    public static void main(String[] args) {
        
        //User u = new User("a@a.com", "123456", Boolean.FALSE);
        //u.setName("alpha");
        //u.create();
        //u = new User("b@b.com", "qwerty", Boolean.TRUE);
        //u.setName("Omega");
        //u.create();
        
        staticFileLocation("/public"); // Static files
        //Code 01: no session
        //Code 02: wrong user or password
        get("/login/:errorCode", new LoginPageHandler());
        post("/loginSession", new LoginSessionHandler());
        //get("/registration/:errorCode", new RegistrationPageHandler());
        post("/newClient", new NewClientHandler());
        
        before("/clients/*", (request, response) -> {
            if(!SessionCheck.isClientLoggedIn(request))
                response.redirect("/login/01",303);
        });
        
        get("/clients/shoppingOrders", new ClientOrderListHandler());
        //get("/clients/order/:orderId", new ClientOrderHandler());
        //get("/clients/newOrder", new OrderPageHandler());
	//post("/clients/createOrder", new NewOrderHandler());
        
        before("/admin/*", (request, response) -> {
            if(!SessionCheck.isAdminLoggedIn(request))
                response.redirect("/login/01",303);
        });
        
        //get("/admin/orderList", new OrderListHandler());
        //get("/admin/registerProduct");
        //post("/admin/createProduct", new NewProductHandler());
        //get("/admin/productList");
        
        before("/admin/orderStatus/:orderId", (request, response) -> {
            // ... check if there's an order with the provided ID
            //response.redirect("/login/01");
        });
        
        //get("/admin/orderStatus/:orderId");
        //post("/admin/processOrder");
        
        
    }
    
}
