/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.db.gui.tree.treenodes_old;

/**
 *
 * @author noriyuki
 */
public class nodeSourceField {
    
    private int number;
    private my.db.classes.core.Field field;
    
    //constructors
    public nodeSourceField(){
        
    }
    public nodeSourceField(my.db.classes.core.Field fld){
        this.field=fld;
    }
    public nodeSourceField(int i,my.db.classes.core.Field fld){
        this.field=fld;
        this.number=i;
    }
    
    //getters and setters
    public void setNumber(int i){
        this.number=i;
    }
    public int getNumber(){
        return this.number;
    }
    public void setField(my.db.classes.core.Field fld){
        this.field=fld;
    }
    public my.db.classes.core.Field getField(){
        return this.field;
    }
    
    //
    public String toString(){
        return this.field.toString();
    }
}
