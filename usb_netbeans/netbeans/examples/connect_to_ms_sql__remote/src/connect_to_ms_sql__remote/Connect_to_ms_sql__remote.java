/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connect_to_ms_sql__remote;
import java.sql.*;

/**
 *
 * @author noriyuki
 */
public class Connect_to_ms_sql__remote {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here            
            try{
                String for_name_string="com.microsoft.sqlserver.jdbc.SQLServerDriver";
                Class.forName(for_name_string);
                String connection_string="jdbc:sqlserver://192.168.0.4\\SQLEXPRESS:1433;database=sugid;user=noriyuki;password=Noriyuki";
                System.out.println(connection_string);
                System.out.println(for_name_string);
                Connection con = DriverManager.getConnection(connection_string);
                //Connection con = DriverManager.getConnection("jdbc:sqlserver://192.168.11.2\\SQLEXPRESS:1433;database=sugid;user=noriyuki;password=Noriyuki");
                
                System.out.println("connect to server successfully.");
                System.err.println(con.getCatalog());
                con.close();
            }
            catch(Exception e){
                System.out.println("an exception occured.");
                System.out.println(e.getMessage());
            }
        }
    }

