/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yz.applications.classes;

/**
 *
 * @author noriyuki
 */
public class BlockNumber {
    
    private String block_no;
    
    public void BlockNumber(String initial_no){
        
        block_no=initial_no;
        
    }
    public String get(){
        
        return block_no;
        
    }
    public void set(String arg){
        
        block_no=arg;
        
    }
}
