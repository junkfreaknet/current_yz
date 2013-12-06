/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package put_database_properties_to_file;
import java.sql.*;
import java.sql.Types;

/**
 *
 * @author noriyuki
 */
public class put_properties_to_file {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            String db_name="sugid";
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection con_to_sugid = DriverManager.getConnection("jdbc:sqlserver://192.168.11.2\\SQLEXPRESS:1433;database=" + db_name + ";user=noriyuki;password=Noriyuki");
                DatabaseMetaData dmd=con_to_sugid.getMetaData();
                
                System.out.println(dmd.getDatabaseProductName());
                System.out.println(dmd.getDatabaseProductVersion());
                System.out.println(db_name);
                
                ResultSet rs_getTables;
                String[] types={"TABLE"};
                rs_getTables=dmd.getTables(null,null,"%",types);
                
                ResultSet rs_getColumns;
                
                int num_tables=0;
                int num_columns=0;
                String buff_num;       
                
                while(rs_getTables.next()){
                    
                    System.out.println("*****");
                    System.out.println("table name");
                    num_tables=num_tables+1;
                    buff_num=String.valueOf(num_tables)+".";
                    System.out.println(buff_num+"    "+rs_getTables.getString("TABLE_NAME"));
                    //System.out.println(" "+rs_getTables.getString("TABLE_CAT"));
                    //System.out.println(" "+rs_getTables.getString("TABLE_SCHEM"));
                    //System.out.println(" "+rs_getTables.getString("TABLE_TYPE"));
                    //System.out.println(" "+rs_getTables.getString("REMARKS"));
                    
                    rs_getColumns=dmd.getColumns(null, null, rs_getTables.getString("TABLE_NAME"), null);
                    System.out.println("columns");
                    num_columns=0;
                    while(rs_getColumns.next()){

                        //System.out.println("    "+rs_getColumns.getString("COLUMN_NAME")+","+rs_getColumns.getString("DATA_TYPE"));
                        num_columns=num_columns+1;
                        buff_num=String.valueOf(num_columns)+".";
                        System.out.println(buff_num+"    "+rs_getColumns.getString("COLUMN_NAME")+","+get_Column_type_as_string(rs_getColumns.getShort("DATA_TYPE"))+","+rs_getColumns.getString("COLUMN_SIZE"));
                    }
                }
        }
                
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    private static String get_Column_type_as_string(Short data_type){
        String rv;
        rv="not defined";
        
        switch(data_type){
            case java.sql.Types.ARRAY:rv="ARRAY";break;
            case java.sql.Types.BIGINT:rv="BIGINT";break;
            case java.sql.Types.BINARY:rv="BINARY";break;
            case java.sql.Types.BIT:rv="BIT";break;
            case java.sql.Types.BLOB:rv="BLOB";break;
            case java.sql.Types.BOOLEAN:rv="BOOLEAN";break;
            case java.sql.Types.CHAR:rv="CHAR";break;
            case java.sql.Types.CLOB:rv="CLOB";break;
            case java.sql.Types.DATALINK:rv="DATALINK";break;
            case java.sql.Types.DATE:rv="DATE";break;
            case java.sql.Types.DECIMAL:rv="DECIMAL";break;
            case java.sql.Types.DISTINCT:rv="DISTINCT";break;
            case java.sql.Types.DOUBLE:rv="DOUBLE";break;
            case java.sql.Types.FLOAT:rv="FLOAT";break;
            case java.sql.Types.INTEGER:rv="INTEGER";break;
            case java.sql.Types.JAVA_OBJECT:rv="JAVA_OBJECT";break;
            case java.sql.Types.LONGNVARCHAR:rv="LONGNVARCHAR";break;
            case java.sql.Types.LONGVARBINARY:rv="LONGVARBINARY";break;
            case java.sql.Types.LONGVARCHAR:rv="LONGVARCHAR";break;
            case java.sql.Types.NCHAR:rv="NCHAR";break;
            case java.sql.Types.NCLOB:rv="NCLOB";break;
            case java.sql.Types.NULL:rv="NULL";break;
            case java.sql.Types.NUMERIC:rv="NUMERIC";break;
            case java.sql.Types.NVARCHAR:rv="NVARCHAR";break;
            case java.sql.Types.OTHER:rv="OTHER";break;
            case java.sql.Types.REAL:rv="REAL";break;
            case java.sql.Types.REF:rv="REF";break;
            case java.sql.Types.ROWID:rv="ROWID";break;
            case java.sql.Types.SMALLINT:rv="SMALLIMT";break;
            case java.sql.Types.SQLXML:rv="SQLXML";break;
            case java.sql.Types.STRUCT:rv="STRUCT";break;
            case java.sql.Types.TIME:rv="TIME";break;
            case java.sql.Types.TIMESTAMP:rv="TIMESTAMP";break;
            case java.sql.Types.TINYINT:rv="TINYINT";break;
            case java.sql.Types.VARBINARY:rv="VARBINARY";break;
            case java.sql.Types.VARCHAR:rv="VARCHAR";break;
            //default
            default:rv="not defined";break;
        }
                
        return rv;
    }
       
}
