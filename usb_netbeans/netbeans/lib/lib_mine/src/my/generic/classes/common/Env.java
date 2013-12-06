/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.generic.classes.common;

/**
 *
 * @author noriyuki
 */
public class Env {
    
    public String OS;
    public String SEPARATOR_FILE;
    public String SEPARATOR_PATH;
    public String HOME;
    
    public Env(){
    
        OS=System.getProperty("os.name");
        SEPARATOR_FILE=System.getProperty("file.separator");
        SEPARATOR_PATH=System.getProperty("path.separator");
        HOME=System.getProperty("user.home");
        
        /*
        System.out.println("from Env.");
        System.out.println(this.HOME);
        System.out.println(this.OS);
        System.out.println(this.SEPARATOR_FILE);
        System.out.println(this.SEPARATOR_PATH);
        System.out.println("from Env is end.");
        */
        
        }
}
