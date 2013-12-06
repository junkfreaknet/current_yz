/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.db.classes.core;

/**
 *
 * @author noriyuki
 */
public class Field {
    
    private String name;
    private FieldType type=new FieldType();
    private FieldLength length=new FieldLength();
    
    //constructor dummy
    public Field(){

    }
    //constructor real
    public Field(String field_name,String field_type_as_string,Short field_type_as_short,int field_length){
        
        this.name=field_name;
        this.type=new FieldType(field_type_as_string,field_type_as_short);
        this.length=new FieldLength(field_length);
    }
    public void setName(String field_name){        
        this.name=field_name;        
    }
    public String getName(){        
        return this.name;        
    }
    public void setType(short type){
        this.type.setType(type);
    }
    public short getTypeAsShort(){        
        return this.type.getTypeAsShort();
    }
    public void setType(String type){        
        this.type.setType(type);
    }
    public String getTypeAsString(){
        
        return this.type.getTypeAsString();
        
    }
    public void setLength(int len){
        this.length.setLength(len);
    }
    public int getLength(){
        return this.length.getLength();
    }
    public my.db.classes.core.FieldType getObjType(){
        return this.type;
    }
    public my.db.classes.core.FieldLength getObjLength(){
        return this.length;
    }
    //
    public String toString(){
        return this.getName();
    }
}
