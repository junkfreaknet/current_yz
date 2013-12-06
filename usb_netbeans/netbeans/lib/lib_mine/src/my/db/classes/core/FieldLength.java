/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.db.classes.core;

/**
 *
 * @author noriyuki
 */
public class FieldLength {
    
    private int length;
    
    //constructor
    public FieldLength(){
        
    }
    public FieldLength(int len){
        this.length=len;
    }
    
    //getter setter
    public void setLength(int len){
        this.length=len;
    }
    public int getLength(){
        return this.length;
    }
    
    //
    public String toString(){
        return String.valueOf(this.length);        
    }
}
