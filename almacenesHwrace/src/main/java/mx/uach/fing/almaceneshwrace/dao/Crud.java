package mx.uach.fing.almaceneshwrace.dao;

import java.util.List;

/**
 * Interface to implement for each model used in the application to do the
 * operations in the database
 * Created Sept 12 2015 @ 11:06 AM
 * @author Jonathan
 * @version 1.0
 */
public interface Crud<T> {

    /**
     *  Method to get a full list of the requested object
     * @return List of objects
     */
    public List<T> list();
    
    /**
     * Method to find for a specific object
     * @param id Id of the object to look for in the DB
     * @return Object or NULL if not found
     */
    public T findObject(Integer id);
    
    /**
     * Method to add an object to the DB
     * @param <T> Object to commit to the DB
     */
    public void create(T t);
    
    /**
     * Method to update the requested object in the DB
     * @param <T> Object to update in the DB
     */
    public void update(T t);
    
    /**
     * Method to delete the requested object from the DB
     * @param id Id of the Object to delete in the DB
     */
    public void delete(Integer id);
}
