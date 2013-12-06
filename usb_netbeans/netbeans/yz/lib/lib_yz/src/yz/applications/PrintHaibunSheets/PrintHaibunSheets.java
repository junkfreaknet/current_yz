/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yz.applications.PrintHaibunSheets;
import yz.applications.classes.*;

/**
 *
 * @author noriyuki
 */
//print haibun sheet  by various conditions
public class PrintHaibunSheets extends Object{
    
    //by block number
    public static void print_haibun_sheets(SiteCode site_cd,ShippingDateAsDBKey shipping_date_as_db_key,ShippingNumber shipping_no,BlockNumber block_start,BlockNumber block_end,Boolean is_confirmed){
        
        yz.applications.PrintHaibunSheetsContents.PrintHaibunSheetsContents proc=new yz.applications.PrintHaibunSheetsContents.PrintHaibunSheetsContents();
        String sql;
        
        sql=proc.create_sql_string_by_block_no(site_cd.get(), shipping_date_as_db_key.get(), shipping_no.get(), block_start.get(), block_end.get(), is_confirmed);
        print_haibun_sheet_common(sql);
    }
    //by display number
    public static void print_haibun_sheets(SiteCode site_cd,ShippingDateAsDBKey shipping_date_as_db_key,ShippingNumber shipping_no,BlockNumber block_number,DisplayNumber[] display_numbers,Boolean is_confirmed){
        
        yz.applications.PrintHaibunSheetsContents.PrintHaibunSheetsContents proc=new yz.applications.PrintHaibunSheetsContents.PrintHaibunSheetsContents();
        String sql;
        
        sql=proc.create_sql_string_by_display_no(site_cd.get(), shipping_date_as_db_key.get(), shipping_no.get(), block_number.get(), display_numbers, is_confirmed);
        print_haibun_sheet_common(sql);
    }
    //by channel number
    public static void print_haibun_sheet_by_ch_no(SiteCode site_cd,ShippingDateAsDBKey shipping_date_as_db_key,ShippingNumber shipping_number,BlockNumber block_number,ChannelNumber channel_number,Boolean is_confirmed){
        
        yz.applications.PrintHaibunSheetsContents.PrintHaibunSheetsContents proc=new yz.applications.PrintHaibunSheetsContents.PrintHaibunSheetsContents();        
        String sql;
        
        sql=proc.create_sql_string_by_ch_no(site_cd.get(), shipping_date_as_db_key.get(), shipping_number.get(), block_number.get(), channel_number.get(), is_confirmed);
        print_haibun_sheet_common(sql);
    }
    //print haibun sheet common
    public static void print_haibun_sheet_common(String sql_string){
        
    }

}
