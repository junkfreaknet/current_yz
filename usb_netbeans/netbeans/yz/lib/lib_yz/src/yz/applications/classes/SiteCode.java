/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yz.applications.classes;

/**
 *
 * @author noriyuki
 */
public class SiteCode {

    private String site_cd;
    
    public void SiteCode(String initial_site_cd){
        
        site_cd=initial_site_cd;
        
    }
    public String get(){
        
        return site_cd;
        
    }
    public void set(String arg){
        
        site_cd=arg;
        
    }
}
