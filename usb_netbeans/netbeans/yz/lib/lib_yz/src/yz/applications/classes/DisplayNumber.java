/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yz.applications.classes;

/**
 *
 * @author noriyuki
 */
public class DisplayNumber {
 
    private String display_no;
    private String shop_cd;
    
    public void DisplayNumber(String initial_display_no,String initial_shop_cd){
        
        display_no=initial_display_no;
        shop_cd=initial_shop_cd;
        
    }
    public DisplayNumber get(){
        
        return this;
        
    }
    public String getDisplayno(){
        
        return this.display_no;
        
    }
    public String getShopCode(){
        
        return this.shop_cd;
        
    }
    public void set(String arg){
        
        display_no=arg;
        
    }
}
