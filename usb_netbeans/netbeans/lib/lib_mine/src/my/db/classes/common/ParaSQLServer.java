/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.db.classes.common;
import my.constants.Constants;
/**
 *
 * @author noriyuki
 */
//paramaters for connect to sql server
public class ParaSQLServer {
 
    private String nam_host;
    private String nam_server_instance;
    private String nam_database;    
    private String nam_product;
    private String port;
    private String user;
    private String pass_word;
    private String for_name_string;
    
    public ParaSQLServer(){
        
        this.for_name_string=Constants.CS_SPACE;
        this.nam_database=Constants.CS_SPACE;
        this.nam_host=Constants.CS_SPACE;
        this.nam_product=Constants.CS_SPACE;
        this.nam_server_instance=Constants.CS_SPACE;
        this.port=Constants.CS_SPACE;
        this.pass_word=Constants.CS_SPACE;
        this.user=Constants.CS_SPACE;
        
    }    
    
    public ParaSQLServer(String host,String sql_server,String database,String product,String port,String user,String pw){

        this.for_name_string=Constants.CS_SPACE;
        this.nam_database=database;
        this.nam_host=host;
        this.nam_product=product;
        this.nam_server_instance=sql_server;
        this.port=port;
        this.pass_word=pw;
        this.user=user;
        
    }

    public ParaSQLServer(String host,String sql_server,String database,String product,String port,String user,String pw,String for_name_string){

        this.for_name_string=for_name_string;
        this.nam_database=database;
        this.nam_host=host;
        this.nam_product=product;
        this.nam_server_instance=sql_server;
        this.port=port;
        this.pass_word=pw;
        this.user=user;
        
    }
    
    public void setForNameString(String buff){
        
        this.for_name_string=buff;
        
    }
    public String createForNameString(){
        
        return this.for_name_string;
        
    }
    public void setNamDataBase(String db_name){
        
        this.nam_database=db_name;
                
    }
    public String getNameDataBase(){
        
        return this.nam_database;
        
    }
    public void setNameHost(String host){
        
        this.nam_host=host;
        
    }
    public String getNameHost(){
        
        return this.nam_host;
        
    }
    public void setNameProduct(String product_name){
        
        this.nam_product=product_name;
        
    }
    public String getNameProduct(){
        
        return this.nam_product;
        
    }
    public void setNameServerInstance(String server_instance){
        
        this.nam_server_instance=server_instance;
        
    }
    public String getNameServerInstance(){
        
        return this.nam_server_instance;
        
    }
    public void setPort(String port_no){
        
        this.port=port_no;
        
    }
    public String getPort(){
        
        return this.port;
        
    }
    public void setPassWord(String pw){
        
        this.pass_word=pw;
        
    }
    public String getPassWord(){
        
        return this.pass_word;
        
    }
    public void setUser(String usr){
        
        this.user=usr;
        
    }
    public String getUser(){
        
        return this.user;
        
    }
    public String getAllParaAsTitle(){
        
        String rv=Constants.CS_SPACE;
        
        //rv="Tables in";
        rv=rv+Constants.CS_BLANK+this.nam_host;
        rv=rv+Constants.CS_BLANK+this.nam_server_instance;
        rv=rv+Constants.CS_BLANK+this.nam_database;
        
        return rv;
        
    }
    public boolean equals(my.db.classes.common.ParaSQLServer para){
        
        if(this.for_name_string.equals(para.for_name_string)){            
        }else{
            return false;
        }
        if(this.nam_database.equals(para.nam_database)){            
        }else{
            return false;
        }
        if(this.nam_host.equals(para.nam_host)){                        
        }else{
            return false;
        }
        if(this.nam_product.equals(para.nam_product)){
            
        }else{
            return false;
        }
        if(this.nam_server_instance.equals(para.nam_server_instance)){
            
        }else{
            return false;
        }
        if(this.pass_word.equals(para.pass_word)){
            
        }else{
            return false;
        }
        if(this.port.equals(para.port)){
            
        }else{
            return false;
        }
        if(this.user.equals(para.user)){
            
        }else{
            return false;
        }
        return true;
    }
}
