/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.db.utilities;
import my.constants.*;

/**
 *
 * @author noriyuki
 */
public class UtilitiesGUI extends Object{
    //
    //Create a db tree.
    //Normal method
    //
    public static javax.swing.JTree createTreeOfDatabase(my.db.classes.common.ParaSQLServerMS para_sqlserver){
        return createTreeOfDatabase((my.db.classes.common.ParaSQLServer)para_sqlserver);
    }     
    public static  javax.swing.JTree createTreeOfDatabase(my.db.classes.common.ParaSQLServer para){

        javax.swing.tree.DefaultTreeModel model=createTreeModelOfDatabase(para);
        
        return new javax.swing.JTree(model);
        
    }
    public static javax.swing.tree.DefaultTreeModel createTreeModelOfDatabase(my.db.classes.common.ParaSQLServerMS para){
        return createTreeModelOfDatabase((my.db.classes.common.ParaSQLServer)para);
    }
    public static javax.swing.tree.DefaultTreeModel createTreeModelOfDatabase(my.db.classes.common.ParaSQLServer para){
        return createTreeModelOfDatabase(para);
    }

    public static javax.swing.tree.DefaultMutableTreeNode createTreeNodeOfDatabase(my.db.classes.common.ParaSQLServer para){    
        my.db.classes.core.Database db=new my.db.classes.core.Database(para);
        //my.db.gui.tree.treenodes.nodeSourceDatabase nodeSourceDatabase=new my.db.gui.tree.treenodes.nodeSourceDatabase(i,db);
        my.db.gui.tree.treenodes_old.nodeSourceDatabase nodeSourceDatabase=new my.db.gui.tree.treenodes_old.nodeSourceDatabase(para);        
        javax.swing.tree.DefaultMutableTreeNode nodeDB=new javax.swing.tree.DefaultMutableTreeNode(nodeSourceDatabase);
        
        //tables begin
        for(int i_tables=Constants.CS_ZERO_AS_INT;i_tables<db.getNumOfTables();i_tables++){

            javax.swing.tree.DefaultMutableTreeNode nodeTable=new javax.swing.tree.DefaultMutableTreeNode(new my.db.gui.tree.treenodes_old.nodeSourceTable(db.getTable(i_tables)));
            //fields begin
            for(int i_fields=Constants.CS_ZERO_AS_INT;i_fields<db.getTable(i_tables).getNumOfFields();i_fields++){
                my.db.gui.tree.treenodes_old.Field nodeField=new my.db.gui.tree.treenodes_old.Field(new my.db.gui.tree.treenodes_old.nodeSourceField(i_fields,db.getTable(i_tables).getField(i_fields)),db.getTable(i_tables).getField(i_fields));                
                nodeTable.add((javax.swing.tree.DefaultMutableTreeNode)nodeField);
            }
            //fields end
            nodeDB.add(nodeTable);            
        }
        return nodeDB;
    }
    public static javax.swing.JTree createTreeOfDatabases(my.db.gui.tree.treenodes_old.nodeSourceDatabases node_source_databases){
        javax.swing.tree.DefaultTreeModel model=createTreeModelOfDatabases(node_source_databases);
        return new javax.swing.JTree(model);
    }
    public static javax.swing.tree.DefaultTreeModel createTreeModelOfDatabases(my.db.gui.tree.treenodes_old.nodeSourceDatabases node_source_databases){
        
        //boolean is_debug=true;
        boolean is_debug=false;
        
        //create tree start
        javax.swing.tree.DefaultMutableTreeNode mutable_node_databases=new javax.swing.tree.DefaultMutableTreeNode(node_source_databases);
        for(int i=Constants.CS_ZERO_AS_INT;i<node_source_databases.getNumOfNodeSourceDatabase();i++){
            if(is_debug){
                System.out.println("i is "+i);
                System.out.println(""+node_source_databases.getNodeSourceDatabase(i));
            }
            if(node_source_databases.getNodeSourceDatabase(i)==null){
                
            }else{
                javax.swing.tree.DefaultMutableTreeNode node=createTreeNodeOfDatabase(node_source_databases.getNodeSourceDatabase(i).getDatabase().getPara());
                mutable_node_databases.add(node);
            }
        }
        //at last
        return new javax.swing.tree.DefaultTreeModel(mutable_node_databases);        
    }
    public static boolean isDatabaseAlreadyExistsOnTree(my.db.classes.common.ParaSQLServer para,my.db.gui.tree.treenodes_old.nodeSourceDatabases node_source_databases){
        
        //check start
        if(node_source_databases==null){
            return false;
        }
        if(node_source_databases.getNumOfNodeSourceDatabase()==Constants.CS_ZERO_AS_INT){
            return false;
        }
        
        for(int i=Constants.CS_ZERO_AS_INT;i<node_source_databases.getNumOfNodeSourceDatabase();i++){
            if(para.equals(node_source_databases.getNodeSourceDatabase(i).getDatabase().getPara())){
                return true;
            }                
        }
        
        return false;                
    }
}
