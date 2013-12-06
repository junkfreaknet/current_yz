

/*
 * Created on 2006/09/09
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

public class MyTestEncoding5 {

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
				
				//if(str_FlagFirst==con_Str_First){
					
					str_Recieve=ConvertFromJISToSysDefault2(byte_in_buffer,0,12);
					System.out.println(str_Recieve);
					//System.out.println(byte_in_buffer);
					str_FlagFirst=con_Str_NotFirst;

				//}
				
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
	static String ConvertFromJISToSysDefault2(byte byte_arg[],int int_offset,int int_length)
		throws UnsupportedEncodingException{
		try{
			
			
			byte[] byte_buff=new byte[int_length+6];
			
			int int_source_index;
			int int_dest_index;
			
			final int ESC_LENGTH=3;
			
			byte_buff[0]=(byte)0x1B;
			byte_buff[1]=(byte)0x24;
			byte_buff[2]=(byte)0x42;
			
			//byte_buff[3]=byte_arg[0];
			//byte_buff[4]=byte_arg[1];
			
			//byte_buff[5]=(byte)0x1B;
			//byte_buff[6]=(byte)0x28;
			//byte_buff[7]=(byte)0x4A;
			
			for(int_source_index=int_offset,int_dest_index=ESC_LENGTH;int_dest_index<byte_buff.length-ESC_LENGTH;int_source_index++,int_dest_index++){
				byte_buff[int_dest_index]=byte_arg[int_source_index];
				
			}
			
			//System.out.println(int_source_index);
			//System.out.println(int_dest_index);
			
			//byte_buff[15]=(byte)0x1B;
			//byte_buff[16]=(byte)0x28;
			//byte_buff[17]=(byte)0x4A;			

			byte_buff[ESC_LENGTH+int_source_index]=(byte)0x1B;
			byte_buff[ESC_LENGTH+int_source_index+1]=(byte)0x28;
			byte_buff[ESC_LENGTH+int_source_index+2]=(byte)0x4A;
			
			String str_Return=new String(byte_buff,"JIS");
			return str_Return;
		}
		finally{
			
		}
	}
	static String ConvertFromJISToSysDefault(byte byte_arg[]) throws UnsupportedEncodingException{
		
			try{
					
					String str_Return="";
					
					String str_Buffer;
					byte byte_jis_si[]={(byte)0x1B,(byte)0x24,(byte)0x42};
					byte byte_jis_so[]={(byte)0x1B,(byte)0x28,(byte)0x4A};

					String str_arg=new String(byte_arg,0,12,"JIS");					
					String str_jis_si=new String(byte_jis_si,"JIS");
					String str_jis_so=new String(byte_jis_so,"JIS");
					
					str_Return.concat(str_jis_si);
					str_Return.concat(str_arg);
					str_Return.concat(str_jis_so);

					System.out.println(str_jis_si);
					System.out.println(str_arg);
					System.out.println(str_jis_so);
					
					//System.out.println(str_Return);
					
					return str_Return;
			}
			finally{
				
			}
	}

	//class end	
}