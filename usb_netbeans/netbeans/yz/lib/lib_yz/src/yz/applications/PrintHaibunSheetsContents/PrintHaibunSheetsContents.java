/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yz.applications.PrintHaibunSheetsContents;
import my.constants.*;
import yz.applications.classes.*;

/**
 *
 * @author noriyuki
 */
public class PrintHaibunSheetsContents extends Object{
    
    public static String create_sql_string_by_block_no(String site_cd,String shipping_date_as_db_key,String shipping_no,String block_start,String block_end,Boolean is_confirmed){
        
        String rv;

        rv=Constants.CS_SPACE;

        return rv;
    }
    public static String create_sql_string_by_display_no(String site_cd,String shipping_date_as_db_key,String shipping_no,String block_number,DisplayNumber[] display_numbers,Boolean is_confirmed){
        String rv;
        rv=Constants.CS_SPACE;
        return rv;
    }
    public static String create_sql_string_by_ch_no(String site_cd,String shipping_date_as_db_key,String shipping_number,String block_number,String channel_number,Boolean is_confirmed){
        String rv;
        rv=Constants.CS_SPACE;
        return rv;
    }    
}
