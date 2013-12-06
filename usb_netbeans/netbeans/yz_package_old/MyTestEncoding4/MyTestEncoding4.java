/*
 * Created on 2006/09/06
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
public class MyTestEncoding4 {

	public static void main(String[] args) {
		try{
			//byte byte_jis[]=new byte[2];
		
			//byte_jis[0]=(byte)0x3A;
			//byte_jis[1]=(byte)0x62;
			
			byte[] byte_jis = {(byte)0x1B,(byte)0x24,(byte)0x42,(byte)0x3A,(byte)0x62,(byte)0x1B,(byte)0x28,(byte)0x4A};
			//byte[] byte_jis = {(byte)0x3A,(byte)0x62};			
			//byte[] byte_jis = {(byte)0x3A,(byte)0x62};			
			String stringJIS=new String(byte_jis,"JIS");			
			//byte[] byte_jis = {(byte)0x93,(byte)0xfa};			
			//String stringJIS=new String(byte_jis,"SJIS");
		
			System.out.println(stringJIS);
			
			//System.out.println(raw2Encoding(stringJIS,"JIS"));
			//System.out.println(raw2Encoding(stringJIS,"SJIS"));
			
			//String stringNew=new String(stringJIS.getBytes("JIS"));
			//System.out.println(stringNew);
			
		}
		catch(UnsupportedEncodingException e){
			
			System.out.println("Unsupported Encoding Excepniotion caused.");
			
		}
	}
	public static String raw2Encoding(String stringRaw,String stringEncoding)
	throws UnsupportedEncodingException{
		
		return (new String(stringRaw.getBytes("8859_1"), stringEncoding));
		
		
	}
}
