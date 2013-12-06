/*
 * Created on 2005/04/18
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package mypackage.file.utility.convert.encoding;

/**
 * @author admnori
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
import java.io.*;

public class MyFileUtilityConvertEncoding extends Object{

	//-----dummy 
	public static void ConvertFilesDummy(String strFile){
		System.out.println("file is "+strFile);
	}
	public static void ConvertFilesDummy(String strFile,int iRecordLength){
		System.out.println("File   is "+strFile);
		System.out.println("Length is "+iRecordLength);
	}
	
	public static void ConvertFileEncodingWithNewLine(String strSourceDir,String strSourceFile,String strSourceEncoding,String strTargetDir,String strTargetFile,String strTargetEncoding,int intRecordLength){

		final String strTypeDefault="default";
		final String strLargeCharEBCDIC="EBCDIC";
		final String strSmallCharEBCDIC="ebcdic";
		final String strCp930="Cp930";
		final String strSJIS="SJIS";
		//final String wkfile="wkfile";
		
		int iSBLength;
		
		StringBuffer sbSourceDir=new StringBuffer(strSourceDir);
		StringBuffer sbSourceFile=new StringBuffer(strSourceFile);
		StringBuffer sbTargetDir=new StringBuffer(strTargetDir);
		StringBuffer sbTargetFile=new StringBuffer(strTargetFile);
		StringBuffer sbSourceEncoding=new StringBuffer(strSourceEncoding);
		StringBuffer sbTargetEncoding=new StringBuffer(strTargetEncoding);
		
		if(strSourceEncoding.equals(strTypeDefault)){
			iSBLength=sbSourceEncoding.length();
			sbSourceEncoding.delete(0,iSBLength);
			sbSourceEncoding.append(System.getProperty("file.encoding"));
			//sbintype.append(strSJIS);
		}
		if(strSourceEncoding.equals(strLargeCharEBCDIC)){
			iSBLength=sbSourceEncoding.length();
			sbSourceEncoding.delete(0,iSBLength);
			sbSourceEncoding.append(strCp930);
		}
		if(strSourceEncoding.equals(strSmallCharEBCDIC)){
			iSBLength=sbSourceEncoding.length();
			sbSourceEncoding.delete(0,iSBLength);
			sbSourceEncoding.append(strCp930);
		}
		if(strTargetEncoding.equals(strTypeDefault)){
			iSBLength=sbTargetEncoding.length();
			sbTargetEncoding.delete(0,iSBLength);
			sbTargetEncoding.append(System.getProperty("file.encoding"));
			//sbouttype.append(strSJIS);
			//System.out.println(sbouttype);
		}
		
		cnvFileEncodingWithNewLine7(sbSourceDir.toString(),sbSourceFile.toString(),sbSourceEncoding.toString(),sbTargetDir.toString(),sbTargetFile.toString(),sbTargetEncoding.toString(),intRecordLength);
		
	}
	
	public static void cnvFileEncodingWithNewLine7(String strSourceDir,String strSourceFile,String strSourceEncoding,String strTargetDir,String strTargetFile,String strTargetEncoding,int intRecordLength){
			try{
				int charcount=0;
				String inbuf;
				StringBuffer sbinbuf=new StringBuffer("");
				int sbbuflength;
				double dblcharcount=0;
				double dblfinfilelength;
				double dblfoutfilelength;
				
				File finfile=new File(strSourceDir,strSourceFile);
				FileInputStream fisinfile=new FileInputStream(finfile);
				InputStreamReader isrinfile=new InputStreamReader(fisinfile,strSourceEncoding);
					
				File foutfile=new File(strTargetDir,strTargetFile);			
				FileOutputStream fosoutfile=new FileOutputStream(foutfile);
				OutputStreamWriter oswoutfile=new OutputStreamWriter(fosoutfile,strTargetEncoding);
				BufferedWriter bw=new BufferedWriter(oswoutfile);
					
				dblfinfilelength=(double)finfile.length();

				/*File finfile=new File(infile);*/

				//BufferedReader br=new BufferedReader(isrinfile);
				
				/*File foutfile=new File(outfile);*/
				
				while((charcount=isrinfile.read())!=-1){
				//while((inbuf=br.readLine()) != null){
					dblcharcount=dblcharcount+1;
					//inbuf=inbuf+charcount;
					//sbinbuf.append(charcount);
					oswoutfile.write(charcount);
					if (((dblcharcount%intRecordLength)==0)){
						//oswoutfile.write("\r");
						//oswoutfile.write("\n");
						//System.out.println(outbuffer);
						//bw.write(outbuffer);
						//System.out.println(inbuf);
						//bw.write(sbinbuf.toString());
						bw.newLine();
						bw.flush();
						//sbbuflength=sbinbuf.length();
						//sbinbuf.delete(0,sbbuflength);
					}
					//if(dblcharcount<10)
					//System.out.println(dblcharcount+":"+charcount);
				}
				
				
				isrinfile.close();
				fisinfile.close();
				
				dblfoutfilelength=(double)foutfile.length();
				bw.close();
				oswoutfile.close();
				fosoutfile.close();

				
				//printIOcharcount("Input File","input",infile,dblfinfilelength,dblcharcount);
				//printIOcharcount("Output File","output",outfile,dblfoutfilelength,dblcharcount);		
			}
			catch(IOException e){
				e.printStackTrace();
			}
			finally{
				
			}
		
	}

}
