/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.db.classes.core;
import java.util.*;
import my.constants.*;

/**
 *
 * @author noriyuki
 */
public class Table {
    
    private String name;
    private List<Field> fields=new ArrayList<Field>();
    
    //constructor dummy
    public Table(){
        
        this.init();
        
    }
    //constructor real
    public Table(String table_name){
        
        this();
        name=table_name;
        
    }
    private void init(){
        this.name=Constants.CS_SPACE;
    }
    public void addField(Field field){

        this.fields.add(field);
        
    }
    public Field getField(int index){
     
        Field rv=new Field();
        if(index>this.fields.size()-1){
            return null;
        }
        rv=this.fields.get(index);
        return rv;
        
    }
    public Field getField(String name){
        
        Field rv=null;
        
        for(Field a_field:fields){   
            if(name.equals(a_field.getName())){
                return a_field;
            }
        }
        return rv;
        
    }
    public ArrayList<Field> getFields(){
        return (ArrayList<Field>)this.fields;
    }
    public void setName(String table_name){
        
        this.name=table_name;
        
    }
    public String getName(){
        
        return this.name;
        
    }

    public int getNumOfFields(){
        
        return this.fields.size();
        
    }
    public String toString(){
        return this.getName();
    }

}
