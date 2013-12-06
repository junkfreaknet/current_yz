/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ViewFieldsOfTables.java
 *
 * Created on 2012/02/10, 22:41:41
 */
package my.utilities.db.gui;
import my.constants.*;
import java.awt.Color;

/**
 *
 * @author noriyuki
 */
public class putFieldsOfDatabasestoXML_re extends javax.swing.JFrame implements javax.swing.event.TreeSelectionListener{

    private javax.swing.JTree tree_of_databases=null;
    private javax.swing.JTree tree_of_xml=null;
    private javax.swing.JTree tree_original;
    
    private my.db.gui.tree.treenodes_old.nodeSourceDatabases node_source_databases=new my.db.gui.tree.treenodes_old.nodeSourceDatabases();   
    private javax.swing.tree.DefaultMutableTreeNode mutable_node_selected;
    
    private static final String CS_NAME_TREE_SOUCE="source";
    private static final String CS_NAME_TREE_TARGET="target";
    /** Creates new form ViewFieldsOfTables */
    public putFieldsOfDatabasestoXML_re() {
        initComponents();       
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pane_main_tabbed = new javax.swing.JTabbedPane();
        pane_tables = new javax.swing.JScrollPane();
        btn_select_a_db_server = new javax.swing.JButton();
        btn_end = new javax.swing.JButton();
        pane_output = new javax.swing.JScrollPane();
        btn_add = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Put fields of databases to XML");
        setName("frm_main"); // NOI18N

        pane_main_tabbed.setName("pane_main_tabbed"); // NOI18N

        pane_tables.setName("pane_tables"); // NOI18N
        pane_main_tabbed.addTab("tables", pane_tables);

        btn_select_a_db_server.setText("Select a db server");
        btn_select_a_db_server.setName("btn_select_a_db_server"); // NOI18N
        btn_select_a_db_server.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_select_a_db_serverMouseClicked(evt);
            }
        });

        btn_end.setText("end");
        btn_end.setName("btn_end"); // NOI18N
        btn_end.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_endMouseClicked(evt);
            }
        });

        pane_output.setName("pane_output"); // NOI18N

        btn_add.setText("--->");
        btn_add.setEnabled(false);
        btn_add.setName("btn_add"); // NOI18N
        btn_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_addMouseClicked(evt);
            }
        });
        btn_add.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_addKeyPressed(evt);
            }
        });

        btn_delete.setText("<---");
        btn_delete.setEnabled(false);
        btn_delete.setName("btn_delete"); // NOI18N
        btn_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_deleteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(btn_select_a_db_server)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_end, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pane_main_tabbed, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(40, 40, 40)
                        .addComponent(pane_output, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(pane_main_tabbed, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(pane_output, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_select_a_db_server)
                            .addComponent(btn_end)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(btn_add)
                        .addGap(42, 42, 42)
                        .addComponent(btn_delete)))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_endMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_endMouseClicked
        // TODO add your handling code here:
        this.common_action_btn_end_clicked();
        
    }//GEN-LAST:event_btn_endMouseClicked

    private void btn_select_a_db_serverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_select_a_db_serverMouseClicked
        // TODO add your handling code here:
        this.common_action_btn_select_a_db_server_clicked();

    }//GEN-LAST:event_btn_select_a_db_serverMouseClicked

    private void btn_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addMouseClicked
        // TODO add your handling code here:
        this.common_action_btn_add_clicked();
    }//GEN-LAST:event_btn_addMouseClicked

    private void btn_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteMouseClicked
        // TODO add your handling code here:
        this.common_action_btn_delete_clicked();
        
    }//GEN-LAST:event_btn_deleteMouseClicked

    private void btn_addKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_addKeyPressed
        // TODO add your handling code here:
        this.common_action_btn_add_clicked();
    }//GEN-LAST:event_btn_addKeyPressed
    //
    private void common_action_btn_add_clicked(){
        
        boolean is_debug=true;
        //boolean is_debug=false;
        
        this.tree_of_xml=my.gui.tree.listener.implementes.TreeOfDatabase.addNodeToTree(mutable_node_selected, tree_of_xml);
        if(this.tree_of_xml==null){
            if(is_debug){
                System.out.println("add action recieves null.");
            }
        }else{
            this.tree_of_xml.setName(this.CS_NAME_TREE_TARGET);
            this.tree_of_xml.addTreeSelectionListener(this);
            this.pane_output.setViewportView(this.tree_of_xml);
        }
        
    }
    private void common_action_btn_delete_clicked(){
        //refresh only
        my.gui.tree.listener.implementes.TreeOfDatabase.deleteNodeFromTree(this.pane_output, mutable_node_selected, tree_of_xml);
    }
    private void common_action_btn_select_a_db_server_clicked(){
    
        my.db.classes.common.ParaSQLServer par_sqlserver=new my.db.classes.common.ParaSQLServer();
        javax.swing.JLabel label=new javax.swing.JLabel();
        
        //par_sqlserver=my.utilities.db.server_selector.ServerChooser.select();        
        par_sqlserver=(my.db.classes.common.ParaSQLServer)my.utilities.db.server_selector.ServerChooser.select();
        if(par_sqlserver==null){
            
        }else{
            if(my.db.utilities.Utilities.isEnableServer(par_sqlserver)){
                if(my.db.utilities.UtilitiesGUI.isDatabaseAlreadyExistsOnTree(par_sqlserver, node_source_databases)){
                }else{
                    this.node_source_databases.addNodeSourceDatabase(par_sqlserver);
                    this.tree_of_databases=my.db.utilities.UtilitiesGUI.createTreeOfDatabases(node_source_databases);
                    if(this.tree_of_databases==null){
                        label.setText("selected db have no tables.");
                        label.setForeground(Color.RED);
                        javax.swing.JOptionPane.showMessageDialog(this, label);
                    }else{
                        this.tree_of_databases.setName(this.CS_NAME_TREE_SOUCE);
                        this.tree_of_databases.addTreeSelectionListener(this);                
                        this.pane_tables.setViewportView(this.tree_of_databases);
                    }            
                }        
            }else{
                //failed connecting to db server
                //when failed
                label.setText("connecting db server is NG.");             
                label.setForeground(Color.RED);        
                javax.swing.JOptionPane.showMessageDialog(this, label);            
            }     
        }
    }
    //tree of database. when node selection is changed action.
    public void valueChanged(javax.swing.event.TreeSelectionEvent e){
        
        boolean is_debug=true;
        //boolean is_debug=false;
        
        //common actions in "source" and "target" trees
        this.mutable_node_selected=(javax.swing.tree.DefaultMutableTreeNode)e.getNewLeadSelectionPath().getLastPathComponent();

        if(is_debug){
            System.out.println("*****valueChange debug start*****");
            
            System.out.println("select "+this.mutable_node_selected.getUserObject()+".");
            //System.out.println(this.mutable_node_selected.getParent().toString());
            
        }
        if(((javax.swing.JTree)e.getSource()).getName().equals(this.CS_NAME_TREE_SOUCE)){
            //source tree
            this.common_action_valueChanged_in_source_tree();
            if(is_debug){
                System.out.println("select source tree");
            }
        }
        
        if(((javax.swing.JTree)e.getSource()).getName().equals(this.CS_NAME_TREE_TARGET)){
            //traget tree
            this.common_action_valueChanged_in_target_tree();
            if(is_debug){
                System.out.println("select target tree");
            }
        }        
        if(is_debug){
            System.out.println("*****valueChange debug end*****");
        }

                
    }
    private void common_action_valueChanged_in_source_tree(){
        this.btn_add.setEnabled(true);
        this.btn_delete.setEnabled(false);        
    }
    private void common_action_valueChanged_in_target_tree(){
        this.btn_add.setEnabled(false);
        this.btn_delete.setEnabled(true);                
    }
    private void common_action_btn_end_clicked(){
        
        this.setVisible(false);
        System.exit(Constants.CS_SYSTEM_EXIT_OK);
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(putFieldsOfDatabasestoXML_re.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(putFieldsOfDatabasestoXML_re.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(putFieldsOfDatabasestoXML_re.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(putFieldsOfDatabasestoXML_re.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new putFieldsOfDatabasestoXML_re().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_end;
    private javax.swing.JButton btn_select_a_db_server;
    private javax.swing.JTabbedPane pane_main_tabbed;
    private javax.swing.JScrollPane pane_output;
    private javax.swing.JScrollPane pane_tables;
    // End of variables declaration//GEN-END:variables
}
