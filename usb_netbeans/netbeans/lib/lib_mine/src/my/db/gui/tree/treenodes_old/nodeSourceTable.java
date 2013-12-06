/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.db.gui.tree.treenodes_old;

/**
 *
 * @author noriyuki
 */
public class nodeSourceTable {

    my.db.classes.core.Table table;
    
    //constructors
    public nodeSourceTable(){
        
    }
    public nodeSourceTable(my.db.classes.core.Table tbl){
        this.table=tbl;
    }
    public void setTable(my.db.classes.core.Table tbl){
        this.table=tbl;
    }
    public my.db.classes.core.Table getTable(){
        return this.table;
    }
    
    //
    public String toString(){
        return this.table.toString();
    }
}
