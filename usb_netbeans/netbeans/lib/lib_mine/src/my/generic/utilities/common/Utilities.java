/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.generic.utilities.common;
import my.constants.*;

/**
 *
 * @author noriyuki
 */
public class Utilities extends Object {
   public static String convertXX_To_SomeDigit99(String xx,int len){
       String rv;
       int i;
       
       rv=xx;
       for(i=Constants.CS_ZERO_AS_INT;i<xx.length();i++){
       rv=Constants.CS_ZERO_AS_STRING+rv;
        }
       return rv;
   }
   /***
   public static String convert_charactor_to_upper(String source){
       
       String rv;
       
       rv=my.constants.Constants.CS_SPACE;
       
       return rv;
   }
   ***/
   public static String convertStringToUpper(String source){
       
       String rv;
       
       rv=Constants.CS_SPACE;
       rv=source.toUpperCase();
       
       return rv;
   }
}
