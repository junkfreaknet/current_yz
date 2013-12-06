/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.db.gui.tree.treenodes_old;
import java.util.*;
import my.constants.Constants;

/**
 *
 * @author noriyuki
 */
public class nodeSourceDatabases {
    
    private String title;
    private List<my.db.gui.tree.treenodes_old.nodeSourceDatabase> node_source_database_s=new ArrayList<my.db.gui.tree.treenodes_old.nodeSourceDatabase>();
    
    //constructors
    public nodeSourceDatabases(){
        this.init();
    }
    public nodeSourceDatabases(String title){
        this.init();
        this.title=title;
    }
    private void init(){
        this.title=my.constants.Constants.CS_SPACE;
    }
    //toString
    public String toString(){
        return this.title+"number of databases "+this.node_source_database_s.size();
    }
    //getters and setters
    public void setTitle(String title){
        this.title=title;
    }
    public String getTitle(){
        return this.title;
    }
    public void addNodeSourceDatabase(my.db.gui.tree.treenodes_old.nodeSourceDatabase node_database){
        this.node_source_database_s.add(node_database);
    }
    public void addNodeSourceDatabase(my.db.classes.common.ParaSQLServer para){
        my.db.gui.tree.treenodes_old.nodeSourceDatabase node_source_database=new my.db.gui.tree.treenodes_old.nodeSourceDatabase(para);
        this.node_source_database_s.add(node_source_database);
    }
    public void addNodeSourceDatabase(my.db.classes.common.ParaSQLServerMS para){
        my.db.gui.tree.treenodes_old.nodeSourceDatabase node_source_database=new my.db.gui.tree.treenodes_old.nodeSourceDatabase(para);
        this.node_source_database_s.add(node_source_database);        
    }
    public void removeNodeSourceDatabase(my.db.gui.tree.treenodes_old.nodeSourceDatabase db){
        
        List<my.db.gui.tree.treenodes_old.nodeSourceDatabase> tmp_list_database=new ArrayList<my.db.gui.tree.treenodes_old.nodeSourceDatabase>();
        my.db.gui.tree.treenodes_old.nodeSourceDatabase node_source_db;
        
        for(int i=Constants.CS_ZERO_AS_INT;i<this.node_source_database_s.size();i++){
            node_source_db=this.node_source_database_s.get(i);
            if(node_source_db.equals(db)){
                
            }else{
                tmp_list_database.add(node_source_db);
                //System.out.println("added "+node_source_db);
                
            }
        }
        //this.node_source_database_s.clear();
        this.node_source_database_s=tmp_list_database;
        
    }
    public my.db.gui.tree.treenodes_old.nodeSourceDatabase getNodeSourceDatabase(int i){
     
        if(i>this.node_source_database_s.size()-1){
            return null;
        }
        return this.node_source_database_s.get(i);        

    }
    public my.db.gui.tree.treenodes_old.nodeSourceDatabase getNodeSourceDatabase(String name){
        
        my.db.gui.tree.treenodes_old.nodeSourceDatabase rv=null;
        for(my.db.gui.tree.treenodes_old.nodeSourceDatabase a_node_source_db:this.node_source_database_s){
            if(name.equals(a_node_source_db.getDatabase().getName())){
                return a_node_source_db;
            }
        }
        return rv;        
    }
    public int getNumOfNodeSourceDatabase(){
        return this.node_source_database_s.size();
    }
}
