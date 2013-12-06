/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yz.applications.classes;

/**
 *
 * @author noriyuki
 */
public class ShippingDateAsDBKey {
    
    private String shipping_date;
    
    public void ShippingDate(String initial_value){
        
        shipping_date=initial_value;
        
    }
    public String get(){
        
        return shipping_date;
        
    }
    public void set(String arg){
        
        shipping_date=arg;
        
    }
    
}
