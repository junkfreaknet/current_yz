/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.utilities.file.file_chooser;
import javax.swing.filechooser.*;

/**
 *
 * @author noriyuki
 */
public class FileChooser extends Object {
 
    public static String select(){
        
        String rv;
        FileChooserGUI fc=new FileChooserGUI();
        rv=fc.select();
        
        return rv;
        
    }
    public static String select(FileNameExtensionFilter file_filter){
        
        String rv;
        FileChooserGUI fc=new FileChooserGUI();
        rv=fc.select(file_filter);       
        
        return rv;
        
    }
}
