/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.db.classes.core;
import my.constants.*;
import java.util.*;

/**
 *
 * @author noriyuki
 */
public class Database {

    private String name;
    private my.db.classes.common.ParaSQLServer para;
    private List<Table> tables=new ArrayList<Table>();
    
    //constructor dummy
    public Database(){
        
        this.init();
        
    }
    //constructor real
    public Database(String name){
        
        this();
        this.name=name;
        
    }
    public Database(my.db.classes.common.ParaSQLServer para){

        Database wk;
        wk=my.db.utilities.Utilities.getPropertiesOfDatabase(para);
        this.name=wk.getName();
        this.tables=wk.getTables();
        this.para=para;        
    
    }
    public Database(my.db.classes.common.ParaSQLServerMS para){
        this((my.db.classes.common.ParaSQLServer)para);
    }
    //
    private void init(){
        
        this.name=Constants.CS_SPACE;
        
    }
    public void setName(String name){
        
        this.name=name;
    }
    public String getName(){
        
        return this.name;
        
    }
    public int getNumOfTables(){
        
        return this.tables.size();
        
    }
    public ArrayList<my.db.classes.core.Table> getTables(){
        return (ArrayList<my.db.classes.core.Table>)this.tables;
    }    
    public my.db.classes.core.Table getTable(int i){
        
        if(i>this.tables.size()-1){
            return null;
        }
        return this.tables.get(i);
    
    }
    public my.db.classes.core.Table getTable(String name){
        
        my.db.classes.core.Table rv=null;
        
        for(my.db.classes.core.Table a_table:tables){
            if(name.equals(a_table.getName())){
                return a_table;
            }
        }
        
        //at last 
        return rv;
    }
    public void addTable(my.db.classes.core.Table table){
        this.tables.add(table);
    }
    public void setPara(my.db.classes.common.ParaSQLServer para){
        this.para=para;
    }
    public void setPara(my.db.classes.common.ParaSQLServerMS para){
        this.setPara((my.db.classes.common.ParaSQLServer)para);
    }
    public my.db.classes.common.ParaSQLServer getPara(){
        return this.para;
    }
    public String toString(){
        return this.getName();
    }

}
