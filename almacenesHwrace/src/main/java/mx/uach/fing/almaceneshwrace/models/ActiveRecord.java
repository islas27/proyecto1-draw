/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.uach.fing.almaceneshwrace.models;

/**
 *
 * @author jesus
 */
public interface ActiveRecord {
        
    public static final String PU = "hwracePU";
    
    void create();
    
    void update();
    
    void delete();
    
}
