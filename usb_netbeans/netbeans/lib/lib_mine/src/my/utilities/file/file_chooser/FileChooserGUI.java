/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.utilities.file.file_chooser;
import javax.swing.*;
import javax.swing.filechooser.*;
import my.constants.*;
import java.io.*;

/**
 *
 * @author noriyuki
 */
public class FileChooserGUI extends JFileChooser{

    public my.generic.classes.common.Env env;
    
    public String select(){

        String rv;
        
        rv=Constants.CS_SPACE;
        env=new my.generic.classes.common.Env();
        File file=new File(env.HOME);
        this.setCurrentDirectory(file);
        rv=this.privately_select();        
        return rv;
        
    }
    public String select(FileNameExtensionFilter file_filter){
        
        String rv;
        
        rv=Constants.CS_SPACE;
        env=new my.generic.classes.common.Env();
        File file=new File(env.HOME);
        this.setCurrentDirectory(file);
        this.addChoosableFileFilter(file_filter);      
        rv=this.privately_select();
        
        return rv;
        
    }
    private String privately_select(){
        
        String rv;
        
        rv=Constants.CS_SPACE;
        int select=this.showOpenDialog(this);
        if(select==JFileChooser.APPROVE_OPTION){
            rv=this.getSelectedFile().getName();
        }
        
        return rv;
        
    }
}
