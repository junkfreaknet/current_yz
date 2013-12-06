/*
 * Created on 2006/08/30
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author admnori
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
import java.io.*;

public class MyTestEncoding2 {

	public static void main(String[] args) {
		try{
			byte byte_Buff[]=new byte[2];
			//byte byte_Buff[];
			//byte_Buff="";
			byte_Buff[0]=58;
			byte_Buff[1]=98;
			
			byte byte_Buff2[]=new byte[2];
			
			String str_Buff=new String(byte_Buff,"JIS");
			byte_Buff2=str_Buff.getBytes("MS932");
			
			
			String str_Buff2=new String(byte_Buff2,"MS932");
		
			System.out.println(str_Buff);
			System.out.println(str_Buff2);
			
			
		}
		catch(UnsupportedEncodingException e){
			System.out.println("Unsupported Encoding Exception.");
		}
	}
}
