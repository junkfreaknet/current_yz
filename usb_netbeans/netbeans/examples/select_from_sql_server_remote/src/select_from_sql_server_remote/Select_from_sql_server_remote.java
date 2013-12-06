/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package select_from_sql_server_remote;
import java.sql.*;

/**
 *
 * @author noriyuki
 */
public class Select_from_sql_server_remote {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
            try{                              
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection con_to_sugid = DriverManager.getConnection("jdbc:sqlserver://192.168.11.2\\SQLEXPRESS:1433;database=sugid;user=noriyuki;password=Noriyuki");
                //System.out.println("connect to server successfully.");
                Statement stmnt_sugid=con_to_sugid.createStatement();
                ResultSet rs_sugid;
                rs_sugid=stmnt_sugid.executeQuery("select * from dbo.tbl_nam_shipping_basic order by display_serial;");
                while(rs_sugid.next()){
                    System.out.println(rs_sugid.getString(1)+","+rs_sugid.getString(2));
                }
                con_to_sugid.close();

                Connection con_to_outfile = DriverManager.getConnection("jdbc:sqlserver://192.168.11.2\\SQLEXPRESS:1433;database=tes_haid;user=noriyuki;password=Noriyuki");
                //System.out.println("connect to server successfully.");
                Statement stmnt_outfile=con_to_outfile.createStatement();
                ResultSet rs_outfile;
                rs_outfile=stmnt_outfile.executeQuery("select distinct syu_ymd,bin_kb,haibun_mad,ad_ten_no from dbo.tbl_outfile order by bin_kb,haibun_mad,ad_ten_no;");
                long cnt_in_outfile=0;
                while(rs_outfile.next()){
                    cnt_in_outfile=cnt_in_outfile+1;
                    System.out.println(rs_outfile.getString(1)+","+rs_outfile.getString(2)+","+rs_outfile.getString(3)+","+rs_outfile.getString(4));
                }                
                System.out.println("outfile read in is "+cnt_in_outfile);
                con_to_outfile.close();
            }
            catch(Exception e){
                System.out.println("an exception occured.");
                System.out.println(e.getMessage());
            }
    }
}
