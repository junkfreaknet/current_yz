/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.utilities.db.server_selector;

/**
 *
 * @author noriyuki
 */
public class ServerChooser extends Object{

    /*
    public static my.db.classes.common.ParaSQLServer select(){
        my.db.classes.common.ParaSQLServer rv=new my.db.classes.common.ParaSQLServer();
        
        my.utilities.db.server_selector.ServerChooserGUI scg=new my.utilities.db.server_selector.ServerChooserGUI(null,true);   
        scg.setVisible(true);
        rv=scg.rv;
        return rv;
    }    
    */
    public static Object select(){
    
        Object rv;
        
        my.utilities.db.server_selector.ServerChooserGUI scg=new my.utilities.db.server_selector.ServerChooserGUI(null, true);
        scg.setVisible(true);
        rv=scg.rv;
        
        return rv;
        
    }

    
}
