/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yz.applications.classes;

/**
 *
 * @author noriyuki
 */
public class ChannelNumber {
    
    private String channel_no;
    
    public void ChannelNumber(String init_channel_no){
        
        channel_no=init_channel_no;
        
    }
    public String get(){
        
        return channel_no;
        
    }
    public void set(String arg){
        
        channel_no=arg;
        
    }
}
