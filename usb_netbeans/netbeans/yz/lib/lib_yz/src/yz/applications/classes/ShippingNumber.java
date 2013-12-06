/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yz.applications.classes;

/**
 *
 * @author noriyuki
 */
public class ShippingNumber {
    
    private String shipping_no;
    
    public void ShippingNumber(String initial_no){
        
        shipping_no=initial_no;
        
    }
    public String get(){
        
        return shipping_no;
        
    }
    public void set(String arg){
        
        shipping_no=arg;
        
    }

}