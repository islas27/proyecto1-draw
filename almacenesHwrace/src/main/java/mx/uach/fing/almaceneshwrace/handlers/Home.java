package mx.uach.fing.almaceneshwrace.handlers;

import mx.uach.fing.almaceneshwrace.handlers.handle.LoginPageHandler;
import mx.uach.fing.almaceneshwrace.handlers.handle.NewProductHandler;
import static spark.Spark.get;
import static spark.Spark.post;

/**
 * Main class of the project. From here spark is going to take control 
 * of the routes of the web application.
 * Created Sept 11  2015 @ 11:38 PM
 * @author Jonathan
 * @version 1.0
 */
public class Home {
    
    public static void main(String[] args) {
        
        get("/login", new LoginPageHandler());
        post("/nuevoProducto", new NewProductHandler());
        post("/registroCliente", (req, res)-> {
            System.out.println(req.body());
            return "";
        });
        /*
	post("/registroCliente");
        get("/compras/:CID");
        get("/nuevaCompra");
	post(" /registrarCompra");
        get("/pedidos");
        get("/pedido/:RID");
	post("/liberarPedido");
        get("/nuevoProducto");
	post("registrarProducto");
        get("/Productos");
     */   
    }
    
}
