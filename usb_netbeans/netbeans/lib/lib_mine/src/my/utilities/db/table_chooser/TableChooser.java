/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.utilities.db.table_chooser;
import java.util.*;

/**
 *
 * @author noriyuki
 */
public class TableChooser {
    
    public static List<my.db.classes.core.Table> select(my.db.classes.common.ParaSQLServer para_sql){
        
        List<my.db.classes.core.Table> rv=new ArrayList<my.db.classes.core.Table>();
        
        my.utilities.db.table_chooser.TableChooserGUI tcg=new my.utilities.db.table_chooser.TableChooserGUI(null, true, para_sql);
        tcg.setVisible(true);
        rv=tcg.rv;
        //rv=my.db.utilities.Utilities.get_table_properties(para_sql);
        return rv;
        
    }
    
}
