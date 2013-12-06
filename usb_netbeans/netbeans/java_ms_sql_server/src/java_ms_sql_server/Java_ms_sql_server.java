/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package java_ms_sql_server;
import java.sql.*;

/**
 *
 * @author noriyuki
 * This is a experimental program for excersise to use ms SQL Server on java
 */
public class Java_ms_sql_server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            long cnt_rec=0;
            Connection con=null;
            Statement stmnt=null;
            ResultSet rs=null;
            String sql_string="select distinct "+
                                "jigyo_cd,"+
                                "syu_ymd,"+
                                "bin_kb,"+
                                "haibun_mad,"+
                                "ad_ten_no"+
                                " from dbo.tbl_outfile "+
                                " order by "+
                                "jigyo_cd,"+
                                "syu_ymd,"+
                                "bin_kb,"+
                                "haibun_mad,"+
                                "ad_ten_no"+                                
                                "";
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"+
                    "instanceName=SQLEXPRESS;"+
                    "databaseName=tes_haid;"+
                    "user=noriyuki;"+
                    "password=Noriyuki");
            
            stmnt=con.createStatement();
            rs=stmnt.executeQuery(sql_string);
            
            while(rs.next()){
                cnt_rec=cnt_rec+1;
            }
            System.out.println("end... read in "+cnt_rec);
            }
        catch(Exception e){
            System.out.println("exception:"+e.getMessage());
            }
        }
    }