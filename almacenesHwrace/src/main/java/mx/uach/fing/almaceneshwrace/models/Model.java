package mx.uach.fing.almaceneshwrace.models;

import java.util.List;

/**
 *
 * @author Jonathan
 */
public interface Model {
    
    List<Product> getAllProducts();
    void createProduct(Product p);
    
    void registerClient(Client c);
    Client getClient(int clientId);
    
    List<Order> getAllOrders();
    boolean existOrder(int orderId);
    void createOrder(Order o);
    void updateOrderStatus(Order o);
    
}
