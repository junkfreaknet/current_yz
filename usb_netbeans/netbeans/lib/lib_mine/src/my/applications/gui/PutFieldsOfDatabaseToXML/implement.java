/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.applications.gui.PutFieldsOfDatabaseToXML;
//import my.gui.tree.listener.implementes.*;
import my.constants.*;

/**
 *
 * @author noriyuki
 */
//public class implement {
class implement{    
    //this must be called "refresh target tree"
    //adding procedures start
    public static javax.swing.JTree addNodeToTree(javax.swing.tree.DefaultMutableTreeNode sourceMutableNode,javax.swing.JTree targetTree){
        
        //boolean is_debug=true;
        boolean is_debug=false;
        
        //debug start
        if (is_debug){
            System.out.println(sourceMutableNode.getUserObject()+","+sourceMutableNode.isLeaf()+","+sourceMutableNode.getParent()+","+sourceMutableNode.getRoot());
            javax.swing.tree.TreeNode[] tree_node_s=sourceMutableNode.getPath();
            
            //
            System.out.println("path is begin.");
            for(javax.swing.tree.TreeNode a_tree_node:sourceMutableNode.getPath()){
                javax.swing.tree.DefaultMutableTreeNode a_mutable_node=(javax.swing.tree.DefaultMutableTreeNode)a_tree_node;
                System.out.println(a_mutable_node.getUserObject());
            }
            System.out.println("path is end");
            //
            
        }
        //debug end    
        
        //when databases
        if(sourceMutableNode.getUserObject() instanceof my.db.gui.tree.treenodes_old.nodeSourceDatabases){
            return new javax.swing.JTree(createTreeModel(sourceMutableNode,(my.db.gui.tree.treenodes_old.nodeSourceDatabases)sourceMutableNode.getUserObject()));
        }
        //when a database
        if(sourceMutableNode.getUserObject() instanceof my.db.gui.tree.treenodes_old.nodeSourceDatabase){
            return new javax.swing.JTree(createTreeModel(sourceMutableNode,targetTree,(my.db.gui.tree.treenodes_old.nodeSourceDatabase)sourceMutableNode.getUserObject()));
        }
        //when a table
        
        //when a field
        
        return null;

    }
    //destroy and build a tree of databases
    private static javax.swing.tree.DefaultTreeModel createTreeModel(javax.swing.tree.DefaultMutableTreeNode sourceMutableNode,my.db.gui.tree.treenodes_old.nodeSourceDatabases nodeSource){
        return my.db.utilities.UtilitiesGUI.createTreeModelOfDatabases((my.db.gui.tree.treenodes_old.nodeSourceDatabases)sourceMutableNode.getUserObject());
    }
    //refresh a tree of database
    private static javax.swing.tree.DefaultTreeModel createTreeModel(javax.swing.tree.DefaultMutableTreeNode sourceMutableNode,javax.swing.JTree targetTree,my.db.gui.tree.treenodes_old.nodeSourceDatabase sourceNode){

        if(targetTree==null){
            
        }else{
            
        }
        return (javax.swing.tree.DefaultTreeModel)targetTree.getModel();
    }
    //adding procedures end
    
    //deleting procedures begin
    static void deleteNodeFromTree(javax.swing.JScrollPane parent,javax.swing.tree.DefaultMutableTreeNode node,javax.swing.JTree tree){
        
        //boolean is_debug=true;
        boolean is_debug=false;
        
        if(is_debug){
            System.out.println("pane is "+parent.getName());
            System.out.println("object is "+node.getUserObject());
        }
        
        //when databases (root) selected        
        if(node.getUserObject() instanceof my.db.gui.tree.treenodes_old.nodeSourceDatabases){
            //deleteNodeFromTree(parent);
            //only destroy a view port view.
            parent.setViewportView(null);
        }
        //when a database selected
        if(node.getUserObject() instanceof my.db.gui.tree.treenodes_old.nodeSourceDatabase){
            parent.setViewportView(refreshTreeForDeleting(node,(my.db.gui.tree.treenodes_old.nodeSourceDatabase)node.getUserObject()));
            //return;
        }
        //at last
        parent.validate();
    }
    /*
    private static void refreshTreeForDeleting(javax.swing.JScrollPane parent){
        parent.setViewportView(null);
    }
    */
    //delete a mutable node of a database
    private static javax.swing.JTree refreshTreeForDeleting(javax.swing.tree.DefaultMutableTreeNode mutable_node_db,my.db.gui.tree.treenodes_old.nodeSourceDatabase node_source_db){

        //boolean is_debug=true;
        boolean is_debug=false;
        
        javax.swing.tree.DefaultMutableTreeNode mutable_node_db_s=(javax.swing.tree.DefaultMutableTreeNode)mutable_node_db.getParent();
        my.db.gui.tree.treenodes_old.nodeSourceDatabases nodeSource_db_s=(my.db.gui.tree.treenodes_old.nodeSourceDatabases)mutable_node_db_s.getUserObject();
        if(nodeSource_db_s.getNumOfNodeSourceDatabase()==(int)1){
            return null;
        }else{
            nodeSource_db_s.removeNodeSourceDatabase(node_source_db);
        }
        //nodeSource_db_s.removeNodeSourceDatabase(node_source_db);
        if(is_debug){
            System.out.println("databases is "+nodeSource_db_s);
        }
        
        return new javax.swing.JTree(my.db.utilities.UtilitiesGUI.createTreeModelOfDatabases(nodeSource_db_s));
    }
    //deleting procedures end
}
