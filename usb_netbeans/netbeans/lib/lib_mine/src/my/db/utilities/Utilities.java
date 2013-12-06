/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.db.utilities;
import my.db.constants.ConstantsDBFields;
import my.db.constants.ConstantsDBDriver;
import java.sql.*;
import java.util.*;
import my.constants.*;

/**
 *
 * @author noriyuki
 */
public class Utilities extends Object{
    
    static boolean if_debug=false;
    //static boolean if_debug=true;
    
    public static boolean isInstanceOfDatabase(Object anyone){
        
        if(anyone instanceof my.db.classes.core.Database ){
            return true;
        }else{
            return false;
        }
        
    }
    public static boolean isInstanceOfTable(Object anyone){
        
        if(anyone instanceof my.db.classes.core.Table){
            return true;
        }else{
            return false;
        }
    }
    public static boolean isInstanceOfField(Object anyone){
        
        if(anyone instanceof my.db.classes.core.Field){
            return true;            
        }else{
            return false;
        }
    }
    public static boolean isEnableServer(Object para){
        return isEnableServer((my.db.classes.common.ParaSQLServer)para);
    }
    public static boolean isEnableServer(my.db.classes.common.ParaSQLServerMS para){
        
        return isEnableServer((my.db.classes.common.ParaSQLServer)para);

    }

    public static boolean isEnableServer(my.db.classes.common.ParaSQLServer para){
        try{
        
        //try to connect begin
        Class.forName(para.createForNameString());
        String connection_string=createConnectionString(para);
        Connection con = DriverManager.getConnection(connection_string);
        con.close();

        //return successful code
        return true;
        
        }
        catch(Exception e){

            return false; //some error caused.
        }        
    }
    public static boolean isDBHasTable(my.db.classes.common.ParaSQLServerMS para){
        
        boolean rv;
        
        rv=isDBHasTable((my.db.classes.common.ParaSQLServer)para);
        return rv;
    }
    public static boolean isDBHasTable(my.db.classes.common.ParaSQLServer para){
        
        boolean rv;
        rv=false;
        
        return rv;
       
    }

    private static ArrayList<my.db.classes.core.Field> getPropertiesOfFields(DatabaseMetaData db_meta_data,String table_name){
        
        ArrayList<my.db.classes.core.Field> rv=new ArrayList<my.db.classes.core.Field>();
        //for debug
        String debug_table_name="";
        String debug_field_name="";
                
        try{
            
            ResultSet rs_columns=getResultSetGetColumns(db_meta_data,null,null,table_name,null);
            while(rs_columns.next()){                                            
                my.db.classes.core.Field field=new my.db.classes.core.Field();
                field.setName(rs_columns.getString(ConstantsDBDriver.FIELD_IN_GETCOLUMNS_COLUMN_NAME));
                field.setType(rs_columns.getShort(ConstantsDBDriver.FIELD_IN_GETCOLUMN_DATA_TYPE));
                field.setType(getFieldTypeAsString(field.getTypeAsShort()));
                field.setLength(rs_columns.getInt(ConstantsDBDriver.FIELD_IN_GETCOLUMN_COLUMN_SIZE));
                debug_table_name=table_name;
                debug_field_name=field.getName();
                rv.add(field);
            }
            
        }catch(Exception e){
            if(if_debug){
                System.out.println(" some error rises adding "+debug_field_name+" to "+debug_table_name);;
            }
        }finally{
            return rv;
        }
    }
    private static ResultSet getResultSetGetTables(DatabaseMetaData db_meta_data,String catalog,String schema,String table_name,String[] types){
        
        ResultSet rv=null;        
        
        try{

            rv=db_meta_data.getTables(catalog,schema,table_name, types);

        }catch(Exception e){
            
        }finally{
            return rv;
        }
    }
    private static ResultSet getResultSetGetColumns(DatabaseMetaData db_meta_data,String schema,String catalog,String table,String col){
        
        ResultSet rv=null;
        
        try{
            
            rv=db_meta_data.getColumns(catalog,schema, table, col);
            
        }catch(Exception e){
            
        }finally{
            return rv;
        }
    }
    private static String getFieldTypeAsString(Short data_type){
        String rv;
        rv=ConstantsDBFields.DB_FIELD_TYPE_UNKNOWN;
        
        switch(data_type){
            case java.sql.Types.ARRAY:rv=ConstantsDBFields.DB_FIELD_TYPE_ARRAY;break;
            case java.sql.Types.BIGINT:rv=ConstantsDBFields.DB_FIELD_TYPE_BIGINT;break;
            case java.sql.Types.BINARY:rv=ConstantsDBFields.DB_FIELD_TYPE_BINARY;break;
            case java.sql.Types.BIT:rv=ConstantsDBFields.DB_FIELD_TYPE_BIT;break;
            case java.sql.Types.BLOB:rv=ConstantsDBFields.DB_FIELD_TYPE_BLOB;break;
            case java.sql.Types.BOOLEAN:rv=ConstantsDBFields.DB_FIELD_TYPE_BOOLEAN;break;
            case java.sql.Types.CHAR:rv=ConstantsDBFields.DB_FIELD_TYPE_CHAR;break;
            case java.sql.Types.CLOB:rv=ConstantsDBFields.DB_FIELD_TYPE_CLOB;break;
            case java.sql.Types.DATALINK:rv=ConstantsDBFields.DB_FIELD_TYPE_DATALINK;break;
            case java.sql.Types.DATE:rv=ConstantsDBFields.DB_FIELD_TYPE_DATE;break;
            case java.sql.Types.DECIMAL:rv=ConstantsDBFields.DB_FIELD_TYPE_DECIMAL;break;
            case java.sql.Types.DISTINCT:rv=ConstantsDBFields.DB_FIELD_TYPE_DISTINCT;break;
            case java.sql.Types.DOUBLE:rv=ConstantsDBFields.DB_FIELD_TYPE_DOUBLE;break;
            case java.sql.Types.FLOAT:rv=ConstantsDBFields.DB_FIELD_TYPE_FLOAT;break;
            case java.sql.Types.INTEGER:rv=ConstantsDBFields.DB_FIELD_TYPE_INTEGER;break;
            case java.sql.Types.JAVA_OBJECT:rv=ConstantsDBFields.DB_FIELD_TYPE_JAVA_OBJECT;break;
            case java.sql.Types.LONGNVARCHAR:rv=ConstantsDBFields.DB_FIELD_TYPE_LONGNVARCHAR;break;
            case java.sql.Types.LONGVARBINARY:rv=ConstantsDBFields.DB_FIELD_TYPE_LONGVARBINARY;break;
            case java.sql.Types.LONGVARCHAR:rv=ConstantsDBFields.DB_FIELD_TYPE_LONGVARCHAR;break;
            case java.sql.Types.NCHAR:rv=ConstantsDBFields.DB_FIELD_TYPE_NCHAR;break;
            case java.sql.Types.NCLOB:rv=ConstantsDBFields.DB_FIELD_TYPE_NCLOB;break;
            case java.sql.Types.NULL:rv=ConstantsDBFields.DB_FIELD_TYPE_NULL;break;
            case java.sql.Types.NUMERIC:rv=ConstantsDBFields.DB_FIELD_TYPE_NUMERIC;break;
            case java.sql.Types.NVARCHAR:rv=ConstantsDBFields.DB_FIELD_TYPE_NVARCHAR;break;
            case java.sql.Types.OTHER:rv=ConstantsDBFields.DB_FIELD_TYPE_OTHER;break;
            case java.sql.Types.REAL:rv=ConstantsDBFields.DB_FIELD_TYPE_REAL;break;
            case java.sql.Types.REF:rv=ConstantsDBFields.DB_FIELD_TYPE_REF;break;
            case java.sql.Types.ROWID:rv=ConstantsDBFields.DB_FIELD_TYPE_ROWID;break;
            case java.sql.Types.SMALLINT:rv=ConstantsDBFields.DB_FIELD_TYPE_SMALLINT;break;
            case java.sql.Types.SQLXML:rv=ConstantsDBFields.DB_FIELD_TYPE_SQLXML;break;
            case java.sql.Types.STRUCT:rv=ConstantsDBFields.DB_FIELD_TYPE_STRUCT;break;
            case java.sql.Types.TIME:rv=ConstantsDBFields.DB_FIELD_TYPE_TIME;break;
            case java.sql.Types.TIMESTAMP:rv=ConstantsDBFields.DB_FIELD_TYPE_TIMESTAMP;break;
            case java.sql.Types.TINYINT:rv=ConstantsDBFields.DB_FIELD_TYPE_TINYINT;break;
            case java.sql.Types.VARBINARY:rv=ConstantsDBFields.DB_FIELD_TYPE_VARBINARY;break;
            case java.sql.Types.VARCHAR:rv=ConstantsDBFields.DB_FIELD_TYPE_VARCHAR;break;
            //default
            default:rv=ConstantsDBFields.DB_FIELD_TYPE_UNKNOWN;break;
        }
                
        return rv;
    }
    private static String createConnectionString(my.db.classes.common.ParaSQLServer par_sqlserver){
        
        String rv="jdbc:"+par_sqlserver.getNameProduct()+"://"+par_sqlserver.getNameHost()+"\\"+par_sqlserver.getNameServerInstance()+":"+par_sqlserver.getPort()+";database="+par_sqlserver.getNameDataBase()+";user="+par_sqlserver.getUser()+";password="+par_sqlserver.getPassWord();                            
        return rv;
        
    }
    public static my.db.classes.core.Database getPropertiesOfDatabase(my.db.classes.common.ParaSQLServerMS para){
        return getPropertiesOfDatabase((my.db.classes.common.ParaSQLServer)para);
    }
    public static my.db.classes.core.Database getPropertiesOfDatabase(my.db.classes.common.ParaSQLServer para){
        
        my.db.classes.core.Database rv=new my.db.classes.core.Database(para.getNameDataBase());       
        
        try{
            
            rv.setName(para.getNameDataBase());
            
            Class.forName(para.createForNameString());
            String connection_string=createConnectionString(para);
            Connection con = DriverManager.getConnection(connection_string);          
            DatabaseMetaData dmd=con.getMetaData();
            
            String types[]={ConstantsDBDriver.RESULTSET_TYPE_TABLE};
            ResultSet rs_tables=getResultSetGetTables(dmd,null,null,ConstantsDBDriver.META_DATA_ALL_TABLES,types);
            
            while(rs_tables.next()){
                
                my.db.classes.core.Table table=new my.db.classes.core.Table();                    

                table.setName(rs_tables.getString(ConstantsDBDriver.FIELD_IN_GETTABLES_TABLE_NAME));
                ArrayList<my.db.classes.core.Field> fields=getPropertiesOfFields(dmd,table.getName());
                for(int i=Constants.CS_ZERO_AS_INT;i<fields.size();i++){
                    table.addField(fields.get(i));
                }
                //rv.add(table);
                rv.addTable(table);
            }
                
            //at last ...
            con.close();        
            
        }catch(Exception e){

        }finally{
            return rv;
        }
    }
}
