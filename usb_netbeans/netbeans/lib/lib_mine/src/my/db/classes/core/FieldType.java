/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.db.classes.core;

/**
 *
 * @author noriyuki
 */
public class FieldType {
    
    String typeAsString;
    Short typeAsShort;
    
    //constructor
    public FieldType(){
        
    }
    public FieldType(String type_as_string,Short type_as_short){
        this.typeAsShort=type_as_short;
        this.typeAsString=type_as_string;
    }
    
    //getters setters
    public void setType(String type){
        this.typeAsString=type;
    }
    public void setType(Short type){
        this.typeAsShort=type;
    }
    public String getTypeAsString(){
        return this.typeAsString;        
    }
    public Short getTypeAsShort(){
        return this.typeAsShort;
    }
    
    //
    public String toString(){
        return this.typeAsString;
    }
}
