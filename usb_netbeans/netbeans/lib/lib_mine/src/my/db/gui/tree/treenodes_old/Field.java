/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.db.gui.tree.treenodes_old;
//import javax.swing.tree.*;

/**
 *
 * @author noriyuki
 */
public class Field extends javax.swing.tree.DefaultMutableTreeNode{
    
    //private javax.swing.tree.DefaultMutableTreeNode nodeSourceField;
    
    //cinstructor
    public Field(){
        
    }
    public Field(my.db.classes.core.Field field){

        super(field);
        
        javax.swing.tree.DefaultMutableTreeNode nodeType=new javax.swing.tree.DefaultMutableTreeNode(field.getObjType());
        javax.swing.tree.DefaultMutableTreeNode nodeLength=new javax.swing.tree.DefaultMutableTreeNode(field.getObjLength());
        
        this.add(nodeType);
        this.add(nodeLength);        
        
    }
    public Field(my.db.gui.tree.treenodes_old.nodeSourceField nodeFld,my.db.classes.core.Field field){
        
        super(nodeFld);
        
        javax.swing.tree.DefaultMutableTreeNode nodeType=new javax.swing.tree.DefaultMutableTreeNode(field.getObjType());
        javax.swing.tree.DefaultMutableTreeNode nodeLength=new javax.swing.tree.DefaultMutableTreeNode(field.getObjLength());
        
        this.add(nodeType);
        this.add(nodeLength);                
        
    }
}
