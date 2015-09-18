package mx.uach.fing.almaceneshwrace.handlers;

import mx.uach.fing.almaceneshwrace.handlers.handle.*;
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
        
        staticFileLocation("/public"); // Static files
        get("/login/:EID", new LoginPageHandler());
        post("/inicioSesion", new LoginSessionHandler());
        //get("/registrate/:EID", new RegistrationPageHandler());
        post("/registroCliente", new NewClientHandler());
        
        before("/cliente/*", (request, response) -> {
            // ... check if authenticated
            
            //response.redirect("/login/01");
        });
        
        //get("/cliente/compras/:CID", new ClientOrderListHandler());
        //get("/cliente/compra/:OID", new ClientOrderHandler());
        //get("/cliente/nuevaCompra", new OrderPageHandler());
	//post("/cliente/registrarCompra", new NewOrderHandler());
        
        before("/admin/*", (request, response) -> {
            // ... check if authenticated
            
            //response.redirect("/login/01");
        });
        
        //get("/admin/pedidos", new OrderListHandler());
        //get("/admin/nuevoProducto");
        //get("/admin/nuevoProducto/:EID");
        //post("/admin/registrarProducto", new NewProductHandler());
        //get("/admin/productos");
        
        before("/admin/pedido/*", (request, response) -> {
            // ... check if there's an order with the provided ID
            
            //response.redirect("/login/01");
        });
        
        //get("/admin/pedido/:RID");
        //post("/admin/liberarPedido");
       
    }
    
}
