/*
 * Created on 2006/08/28
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
import java.io.UnsupportedEncodingException;

public class MyTestEncoding {

	public static void main(String[] args) {
		try{
			
			
			//trick
			
			final String con_Str_First="0";
			final String con_Str_NotFirst="1";
			
			String str_FlagFirst=con_Str_First;
			
			//trick end
			final String str_IN_FILE_NAME="TANCPJ";
			final String str_OUT_FILE_NAME="TANCPJOUT";
			
			final int int_IN_FILE_LENGTH=62;
			final int int_START_POS_KANJI=0;
			final int int_LENGTH_OF_KANJI=12;
			

			
			File file_infile=new File(str_IN_FILE_NAME);
			FileInputStream fis_infile=new FileInputStream(file_infile);
			
			File file_outfile=new File(str_OUT_FILE_NAME);
			FileOutputStream fos_outfile=new FileOutputStream(file_outfile);

			int int_CountOfRead;
			
			int int_OffSetForRead=0;
			byte byte_in_buffer[]=new byte[int_IN_FILE_LENGTH];
			String str_Recieve;
			
			while((int_CountOfRead=fis_infile.read(byte_in_buffer))!=-1){
				
				if(str_FlagFirst==con_Str_First){
					
					str_Recieve=GetKanji(byte_in_buffer);
					System.out.println(str_Recieve);
					System.out.println(byte_in_buffer);
					str_FlagFirst=con_Str_NotFirst;
				}
				
			}
			
			fis_infile.close();
			
		}
		catch(IOException e){
			System.out.println("Error IOException:");			
			System.out.println(e.getMessage());
			return;
		}

		finally{
			
		}
	//main end
	}
	static String GetKanji(byte byte_arg[]) throws UnsupportedEncodingException{
		
			try{
					String str_Buffer=new String(byte_arg,0,12,"JIS");
					byte byte_Buffer[]=new byte[12];
					
					byte_Buffer=str_Buffer.getBytes();
					String str_Result=new String(byte_Buffer,"MS932");
					
					//System.out.println(byte_arg);
					System.out.println(str_Buffer.length());
					System.out.println(byte_Buffer);
					System.out.println(str_Result);
					
					//byte_Buffer=str_Buffer.getBytes();
					
					//return str_Return;
					return str_Buffer;
			}
			finally{
				
			}
	}

	//class end	
}
