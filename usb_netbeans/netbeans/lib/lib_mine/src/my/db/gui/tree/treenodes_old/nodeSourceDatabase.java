/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.db.gui.tree.treenodes_old;

/**
 *
 * @author noriyuki
 */
public class nodeSourceDatabase {
    
    private my.db.classes.core.Database database;
    
    //constructors
    public nodeSourceDatabase(){
        
    }
    public nodeSourceDatabase(my.db.classes.core.Database db){
        this.database=db;
    }
    public nodeSourceDatabase(my.db.classes.common.ParaSQLServer para){
        this.database=new my.db.classes.core.Database(para);
    }
    public nodeSourceDatabase(my.db.classes.common.ParaSQLServerMS para){
        this((my.db.classes.common.ParaSQLServer)para);
    }
    public void setDatabase(my.db.classes.core.Database db){
        this.database=db;
    }
    public my.db.classes.core.Database getDatabase(){
        return this.database;
    }
    //
    public String toString(){
        return this.database.toString();
    }
    public boolean equals(my.db.gui.tree.treenodes_old.nodeSourceDatabase db){
        
        if(this.database.getPara().equals(db.getDatabase().getPara())){
            return true;
        }else{
            return false;
        }
    }
    
}
