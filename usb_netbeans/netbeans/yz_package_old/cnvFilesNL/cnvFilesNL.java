
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
/*import java .lang.*;*/
/*import java.lang.*;*/
//import java.lang.*;

/* Define error handling */
/*class MainExceptionNumOfArg extends Exception{
	public MainExceptionNumOfArg(String errorstring){super(errorstring);}
}*/
public class cnvFilesNL {
	//public static final int NUMARG = 4;
	public static final int NUMARG7=7;
	public static final int NUMARG5=5;
	
	public static void main(String[] args) {
		try{
			/* constants */
			final String strTypeDefault="default";
			final String strLargeCharEBCDIC="EBCDIC";
			final String strSmallCharEBCDIC="ebcdic";
			final String strCp930="Cp930";
			final String strSJIS="SJIS";
			final String wkfile="wkfile";
			
			/* variables */
			String indir;
			String infile;
			String outdir;
			String outfile;
			String intype;
			String outtype;
			int reclength; //input record length
			int sblength;
			
			System.out.println("*** Program cnvFiles Start. ***");
			checknumofarg(args.length);
			

			/* set paramaters */
			if (args.length==NUMARG7){
				indir=args[0];
				infile=args[1];
				outdir=args[2];
				outfile=args[3];
				intype=args[4];
				outtype=args[5];
				reclength=Integer.valueOf(args[6]).intValue();
			}else{
				infile=args[0];
				outfile=args[1];
				intype=args[2];
				outtype=args[3];
				reclength=Integer.valueOf(args[4]).intValue();
				indir="";
				outdir="";				
			}
			
			StringBuffer sbindir=new StringBuffer(indir);
			StringBuffer sbinfile=new StringBuffer(infile);
			StringBuffer sboutdir=new StringBuffer(outdir);
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
			
			if(args.length==NUMARG7){
				checkDirectory(indir);
				checkFileAndDirectory(indir,infile);
				checkDirectory(outdir);
			}
			if(args.length==NUMARG5){
				checkfileexist(infile);
			}

			cnvFilesAddNewLine(args.length,sbindir.toString(),sbinfile.toString(),sboutdir.toString(),sboutfile.toString(),sbintype.toString(),sbouttype.toString(),reclength);			
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
			System.out.println("Require 5 arguments.");
			return;
		}
		/*catch(MainExceptionNumOfArg e){
			System.out.println("Error:");			
			/*System.out.println(e.getMessage());*/
		/*	System.out.println("Usage:cnvFiles infile outfile intype outtype record_length.");
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

static void checknumofarg(int numofarg) /*throws MainExceptionNumOfArg*/
{
	/*System.out.println(numofarg);*/
	if (numofarg==NUMARG7){
		return;
	}
	if (numofarg==NUMARG5){
		return;
	}
	/*throw new MainExceptionNumOfArg("Errorprogram 4 arguments");*/
	System.out.println("Error:");			
	/*System.out.println(e.getMessage());*/
	System.out.println("Usage:cnvFiles infile outfile intype outtype record_length. Or");
	System.out.println("Usage:cnvFiles indir infile outdir outfile intype outtype record_length.");
	//terminate this program.
	System.exit(0);
	/*return;*/	
}

static void checkfileexist(String targetfile) throws IOException{
	try{
		File ftargetfile=new File(targetfile);			
		if(!ftargetfile.exists()||!ftargetfile.isFile())
			throw new IOException("File "+targetfile+" is not exist.");
	}
	finally{
		
	}
		
}
static void checkFileAndDirectory(String targetdir,String targetfile) throws IOException{
	try{
		File ftargetfile=new File(targetdir,targetfile);
		if(!ftargetfile.exists()||!ftargetfile.isFile())
			throw new IOException(targetdir+" and " +targetfile+" are not exist.");		
	}
	finally{
		
	}
}
static void checkDirectory(String targetdir) throws IOException{
	try{
		File ftargetdir=new File(targetdir);
		if(!ftargetdir.exists()||!ftargetdir.isDirectory())
			throw new IOException("Directory "+targetdir+" is not exist.");
	}
	finally{
		
	}
}

static void cnvFilesAddNewLine(int numofarg,String indir,String infile,String outdir,String outfile,String intype,String outtype,int reclength)
throws FileNotFoundException,UnsupportedEncodingException,IOException{
	try{
		if (numofarg==NUMARG7){
			cnvFilesAddNewLineArg7(indir,infile,outdir,outfile,intype,outtype,reclength);
		} else if (numofarg==NUMARG5){
			cnvFilesAddNewLineArg5(infile,outfile,intype,outtype,reclength);
		} else{
			System.out.println("error.");
			System.out.println("count of arguments.");
			System.out.println("exit this program.");
			System.exit(0);
		}
	}
	finally{
		
	}
}
static void cnvFilesAddNewLineArg7 (String indir,String infile,String outdir,String outfile,String intype,String outtype,int reclength)
throws FileNotFoundException,UnsupportedEncodingException,IOException{
	try{
		int charcount=0;
		String inbuf;
		StringBuffer sbinbuf=new StringBuffer("");
		int sbbuflength;
		double dblcharcount=0;
		double dblfinfilelength;
		double dblfoutfilelength;
		
		File finfile=new File(indir,infile);
		FileInputStream fisinfile=new FileInputStream(finfile);
		InputStreamReader isrinfile=new InputStreamReader(fisinfile,intype);
			
		File foutfile=new File(outdir,outfile);			
		FileOutputStream fosoutfile=new FileOutputStream(foutfile);
		OutputStreamWriter oswoutfile=new OutputStreamWriter(fosoutfile,outtype);
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
			if (((dblcharcount%reclength)==0)){
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

		
		printIOcharcount("Input File","input",infile,dblfinfilelength,dblcharcount);
		printIOcharcount("Output File","output",outfile,dblfoutfilelength,dblcharcount);		
	}
	finally{
		
	}
}
static void cnvFilesAddNewLineArg5 (String infile,String outfile,String intype,String outtype,int reclength)
throws FileNotFoundException,UnsupportedEncodingException,IOException{
	try{
		int charcount=0;
		String inbuf;
		StringBuffer sbinbuf=new StringBuffer("");
		int sbbuflength;
		double dblcharcount=0;
		double dblfinfilelength;
		double dblfoutfilelength;
		
		/*System.out.println(infile);
		System.out.println(outfile);
		System.out.println(intype);
		System.out.println(outtype);
		System.out.println(reclength);*/
		//System.out.println(System.getProperty("line.separator"));
		
		File finfile=new File(infile);
		FileInputStream fisinfile=new FileInputStream(finfile);
		InputStreamReader isrinfile=new InputStreamReader(fisinfile,intype);
			
		File foutfile=new File(outfile);			
		FileOutputStream fosoutfile=new FileOutputStream(foutfile);
		OutputStreamWriter oswoutfile=new OutputStreamWriter(fosoutfile,outtype);
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
			if (((dblcharcount%reclength)==0)){
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

		
		printIOcharcount("Input File","input",infile,dblfinfilelength,dblcharcount);
		printIOcharcount("Output File","output",outfile,dblfoutfilelength,dblcharcount);		
	}
	finally{
		
	}
}
static void printIOcharcount (String filetype,String fileaction,String targetfile,double dblfilelength,double dblcharcount) {
	System.out.println("* Information");
	System.out.println(filetype+" length of " +targetfile+" is "+dblfilelength+" characters.");
	System.out.println(targetfile+" has "+dblcharcount+" characters "+fileaction+".");
}
}
