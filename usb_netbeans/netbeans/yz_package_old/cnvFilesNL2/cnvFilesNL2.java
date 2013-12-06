
/*
 * Created on 2004/10/10
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
import java.lang.*;
//import java.lang.*;

/* Define error handling */
class MainExceptionNumOfArg extends Exception{
	public MainExceptionNumOfArg(String errorstring){super(errorstring);}
}
public class cnvFilesNL2 {
	//public static final int NUMARG = 4;
	public static final int NUMARG = 5;
	
	public static void main(String[] args) {
		try{
			/* constants */
			final String strTypeDefault="default";
			final String strLargeCharEBCDIC="EBCDIC";
			final String strSmallCharEBCDIC="ebcdic";
			final String strCp930="Cp930";
			final String strSJIS="SJIS";
			
			/* variables */
			String infile;
			String outfile;
			String intype;
			String outtype;
			int reclength; //input record length
			int sblength;
			
			System.out.println("*** Program cnvFiles Start. ***");
			checknumofarg(args.length);
			

			/* set paramaters */
			infile=args[0];
			outfile=args[1];
			intype=args[2];
			outtype=args[3];
			reclength=Integer.valueOf(args[4]).intValue();
			
			StringBuffer sbinfile=new StringBuffer(infile);
			StringBuffer sboutfile=new StringBuffer(outfile);
			StringBuffer sbintype=new StringBuffer(intype);
			StringBuffer sbouttype=new StringBuffer(outtype);
			
			if(intype.equals(strTypeDefault)){
				sblength=sbintype.length();
				sbintype.delete(0,sblength);
				sbintype.append(System.getProperty("file.encoding"));
				//sbintype.append(strSJIS);
			}
			if(intype.equals(strLargeCharEBCDIC)){
				sblength=sbintype.length();
				sbintype.delete(0,sblength);
				sbintype.append(strCp930);
			}
			if(intype.equals(strSmallCharEBCDIC)){
				sblength=sbintype.length();
				sbintype.delete(0,sblength);
				sbintype.append(strCp930);
			}
			if(outtype.equals(strTypeDefault)){
				sblength=sbouttype.length();
				sbouttype.delete(0,sblength);
				sbouttype.append(System.getProperty("file.encoding"));
				//sbouttype.append(strSJIS);
				//System.out.println(sbouttype);
			}
			
			checkfileexist(infile);
			cnvFileEncode(sbinfile.toString(),sboutfile.toString(),sbintype.toString(),sbouttype.toString());
			//cnvFileEncodeNL(sbinfile.toString(),sboutfile.toString(),sbintype.toString(),sbouttype.toString());
			//cnvFileEncodeCRLF(sbinfile.toString(),sboutfile.toString(),sbintype.toString(),sbouttype.toString(),reclength);
			//cnvFileEncodeBW(sbinfile.toString(),sboutfile.toString(),sbintype.toString(),sbouttype.toString(),reclength);			
			System.out.println("cnvFiles ended successfully.");
		}
		/*
		 * ***
		 * *** Error handlings in main
		 * *** 
		 */
		/* cnvFiles mumt hava 4 arguments */
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Error:");
			System.out.println("Require 4 arguments.");
			return;
		}
		catch(MainExceptionNumOfArg e){
			System.out.println("Error:");			
			System.out.println(e.getMessage());
			System.out.println("Usage:cnvFiles infile outfile intype outtype.");
			return;
		}
		/*
		 * Error handlings about File IO
		 */
		catch(FileNotFoundException e){
			System.out.println("Error");
			System.out.println("File not found exception.");
			return;
		}
		catch(UnsupportedEncodingException e){
			System.out.println("Error");
			System.out.println("Unsupported encoding exception");
			return;
		}
		catch(IOException e){
			System.out.println("Error:");			
			System.out.println(e.getMessage());
			return;
		}

		/*
		 * final procedure
		 */
		finally{
			System.out.println("*** Program cnvFiles End. ***");
			
		}

	}

static void checknumofarg(int numofarg) throws MainExceptionNumOfArg{
	if (numofarg!=NUMARG)
		throw new MainExceptionNumOfArg("Errorprogram 4 arguments");
}

static void checkfileexist(String targetfile) throws IOException{
	try{
		File ftargetfile=new File(targetfile);			
		if(!ftargetfile.exists()||!ftargetfile.isFile())
			throw new IOException(targetfile+" is not exist.");
	}
	finally{
		
	}
		
}
static void cnvFileEncode (String infile,String outfile,String intype,String outtype)
	throws FileNotFoundException,UnsupportedEncodingException,IOException{
	try{
		int charcount;
		double dblcharcount=0;
		double dblfinfilelength;
		double dblfoutfilelength;

		
		File finfile=new File(infile);
		FileInputStream fisinfile=new FileInputStream(finfile);
		InputStreamReader isrinfile=new InputStreamReader(fisinfile,intype);
		
		File foutfile=new File(outfile);
		FileOutputStream fosoutfile=new FileOutputStream(foutfile);
		OutputStreamWriter oswoutfile=new OutputStreamWriter(fosoutfile,outtype);
		
		dblfinfilelength=(double)finfile.length();
		while((charcount=isrinfile.read())!=-1){
			dblcharcount=dblcharcount+1;
			oswoutfile.write(charcount);
			/*if(dblcharcount<10)
			System.out.println(dblcharcount+":"+charcount);*/
		}
		
		
		isrinfile.close();
		fisinfile.close();
		
		dblfoutfilelength=(double)foutfile.length();
		oswoutfile.close();
		fosoutfile.close();
		
		printIOcharcount("Input File","input",infile,dblfinfilelength,dblcharcount);
		printIOcharcount("Output File","output",outfile,dblfoutfilelength,dblcharcount);
	}
	/* finally is empty now. */
	finally{
		
	}		
}
static void cnvFileEncodeNL (String infile,String outfile,String intype,String outtype)
throws FileNotFoundException,UnsupportedEncodingException,IOException{
	try{
		InputStream is;
		OutputStream os;
		is=new FileInputStream(infile);
		os=new FileOutputStream(outfile);
		char[] buffer=new char[4096];
		int len;
		
		Reader r=new BufferedReader(new InputStreamReader(is,intype));
		Writer w=new BufferedWriter(new OutputStreamWriter(os,outtype));
		
		while((len = r.read(buffer)) != -1)
			w.write(buffer,0,len);
			r.close();
			w.flush();
			w.close();
	}
	finally{
		
	}
}
static void cnvFileEncodeCRLF (String infile,String outfile,String intype,String outtype,int reclength)
throws FileNotFoundException,UnsupportedEncodingException,IOException{
	try{
		int charcount;
		double dblcharcount=0;
		double dblfinfilelength;
		double dblfoutfilelength;

		
		File finfile=new File(infile);
		FileInputStream fisinfile=new FileInputStream(finfile);
		InputStreamReader isrinfile=new InputStreamReader(fisinfile,intype);
		
		File foutfile=new File(outfile);
		FileOutputStream fosoutfile=new FileOutputStream(foutfile);
		OutputStreamWriter oswoutfile=new OutputStreamWriter(fosoutfile,outtype);
		
		dblfinfilelength=(double)finfile.length();
		while((charcount=isrinfile.read())!=-1){
			dblcharcount=dblcharcount+1;
			oswoutfile.write(charcount);
			if (((dblcharcount%reclength)==0)){
				oswoutfile.write("\r");
				oswoutfile.write("\n");
				//oswoutfile.write(charcount);
			}
			//if(dblcharcount<10)
			//System.out.println(dblcharcount+":"+charcount);
		}
		
		
		isrinfile.close();
		fisinfile.close();
		
		dblfoutfilelength=(double)foutfile.length();
		oswoutfile.close();
		fosoutfile.close();
		
		printIOcharcount("Input File","input",infile,dblfinfilelength,dblcharcount);
		printIOcharcount("Output File","output",outfile,dblfoutfilelength,dblcharcount);		
	}
	finally{
		
	}
}
static void cnvFileEncodeBW (String infile,String outfile,String intype,String outtype,int reclength)
throws FileNotFoundException,UnsupportedEncodingException,IOException{
	try{
		int charcount;
		String outbuffer;
		double dblcharcount=0;
		double dblfinfilelength;
		double dblfoutfilelength;

		
		File finfile=new File(infile);
		FileInputStream fisinfile=new FileInputStream(finfile);
		InputStreamReader isrinfile=new InputStreamReader(fisinfile,intype);
		
		File foutfile=new File(outfile);
		BufferedWriter bw=new BufferedWriter(new FileWriter(foutfile));
		//FileOutputStream fosoutfile=new FileOutputStream(foutfile);
		//OutputStreamWriter oswoutfile=new OutputStreamWriter(fosoutfile,outtype);
		
		dblfinfilelength=(double)finfile.length();
		outbuffer="";
		
		while((charcount=isrinfile.read())!=-1){
			dblcharcount=dblcharcount+1;
			outbuffer=outbuffer+charcount;
			//oswoutfile.write(charcount);
			if (((dblcharcount%reclength)==0)){
				//oswoutfile.write("\r");
				//oswoutfile.write("\n");
				bw.write(outbuffer);
				bw.newLine();
				outbuffer="";

			}
			//if(dblcharcount<10)
			//System.out.println(dblcharcount+":"+charcount);
		}
		
		
		isrinfile.close();
		fisinfile.close();
		
		dblfoutfilelength=(double)foutfile.length();
		bw.close();
		//oswoutfile.close();
		//fosoutfile.close();
		
		printIOcharcount("Input File","input",infile,dblfinfilelength,dblcharcount);
		printIOcharcount("Output File","output",outfile,dblfoutfilelength,dblcharcount);		
	}
	finally{
		
	}
}
static void printIOcharcount (String filetype,String fileaction,String targetfile,double dblfilelength,double dblcharcount) {
	System.out.println("* Information");
	System.out.println(filetype+" length of " +targetfile+" is "+dblcharcount+" characters.");
	/*System.out.println(targetfile+" has "+dblcharcount+" characters "+fileaction+".");*/
}
}
