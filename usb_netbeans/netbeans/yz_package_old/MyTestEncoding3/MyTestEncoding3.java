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

public class MyTestEncoding3 {

	public static void main(String[] args) {
			try{
			String str_Buff="На";
			byte byte_int[]= str_Buff.getBytes("JIS");
			String str_Buff2=new String(byte_int);
			byte byte_int2[]=str_Buff2.getBytes();
			String str_Buff3=new String(byte_int2,"MS932");
			
			
			System.out.println("default encoding is " + System.getProperty("file.encoding"));
			System.out.println(str_Buff);
			System.out.println(byte_int[0]);
			System.out.println(byte_int[1]);
			System.out.println(byte_int2[0]);
			System.out.println(byte_int2[1]);
			System.out.println(str_Buff2);
			System.out.println(str_Buff3);
			}
			//System.out.println(byte_int[0]);
			//System.out.println(byte_int[1]);
			catch(UnsupportedEncodingException e){
				System.out.println("Unsupported Encoding Exception.");
			}
	}
}
