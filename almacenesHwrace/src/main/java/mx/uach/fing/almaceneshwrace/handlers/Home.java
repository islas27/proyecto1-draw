package mx.uach.fing.almaceneshwrace.handlers;

import mx.uach.fing.almaceneshwrace.dao.Crud;
import mx.uach.fing.almaceneshwrace.dao.ProductsDao;
import mx.uach.fing.almaceneshwrace.handlers.handle.LandingPageHandler;
import mx.uach.fing.almaceneshwrace.handlers.handle.LoginPageHandler;
import mx.uach.fing.almaceneshwrace.handlers.handle.NewProductHandler;
import static spark.Spark.get;
import static spark.Spark.post;

/**
 * Main class of the project. From here spark is going to hace control 
 * of the routes of the web aplication.
 * Created Sept 11  2015 @ 11:38 PM
 * @author Jonathan
 * @version 1.0
 */
public class Home {
    
    public static void main(String[] args) {
        
        Crud Pdao = new ProductsDao();
        //Crud Cdao = new ClientsDao();
        
        
        get("/home", new LandingPageHandler(null));
        get("/login", new LoginPageHandler(null));
        post("/nuevoProducto", new NewProductHandler(Pdao));
        /*get("/registrate");
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
