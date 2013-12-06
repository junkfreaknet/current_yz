/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.db.constants;

/**
 *
 * @author noriyuki
 * this is a constant values for paramaters to manipulate database on java
 */
public class ConstantsDBDriver {
    
    //result set types
    public static final String RESULTSET_TYPE_TABLE="TABLE";
    
    //meta data 
    public static final String META_DATA_ALL_TABLES="%";
    
    //fields in result set of getTables method
    public static final String FIELD_IN_GETTABLES_TABLE_NAME="TABLE_NAME";
    
    //fields in result set of getColumns method
    public static final String FIELD_IN_GETCOLUMNS_COLUMN_NAME="COLUMN_NAME";
    public static final String FIELD_IN_GETCOLUMN_DATA_TYPE="DATA_TYPE";
    public static final String FIELD_IN_GETCOLUMN_COLUMN_SIZE="COLUMN_SIZE";
    
}
