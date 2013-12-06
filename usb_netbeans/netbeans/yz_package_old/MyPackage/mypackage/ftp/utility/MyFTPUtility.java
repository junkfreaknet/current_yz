/*
 * Created on 2005/03/27
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package mypackage.ftp.utility;
import java.io.*;

import org.apache.commons.net.ftp.*;
import myclass.ftp.*;
import mypackage.file.utility.*;

/**
 * @author admnori
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class MyFTPUtility extends Object{
	
	public static FTPClientReturn Connect(String strFTPServer){
		
		boolean bStat;
		FTPClient ftpclient=new FTPClient();
		FTPClientReturn returns=new FTPClientReturn();
		
		returns.bResult=true;
		
		try{
			
			ftpclient.connect(strFTPServer);
			bStat=TestResult(ftpclient,"connect");
			if(!bStat){
				ftpclient.disconnect();
				throw new IOException();
			}
		}
		
		catch(IOException e){
			
			returns.bResult=false;
			
		}
		
		finally{
			returns.ftpclient=ftpclient;
		}
		
		return returns;
		
	}
		
	public static FTPClientReturn Login(FTPClientReturn returns,String strFTPUserName,String strFTPPassWord){

		boolean bStat;
		
		try{
			
			if(returns.ftpclient.isConnected()){
				returns.bResult=returns.ftpclient.login(strFTPUserName,strFTPPassWord);
				bStat=TestResult(returns.ftpclient,"login");
				if(!bStat){
					throw new IOException();
				}
			}
			
		}
		catch(IOException e){
			
			returns.bResult=false;
			
		}
		finally{
			
		}
		return returns;
	}
	
	public static FTPClientReturn Disconnect(FTPClientReturn returns){
		
		try{
			if(returns.ftpclient.isConnected()){
				returns.ftpclient.disconnect();
			}
		}
		catch(IOException e){
			
			returns.bResult=false;
			
		}
		finally{
			
		}
		return returns;
	}
	public static FTPClientReturn ChangeDirectory(FTPClientReturn returns,String strDirectory){
		
		boolean bIsSuccess;
		
		try{
			
			returns.bResult=returns.ftpclient.changeWorkingDirectory(strDirectory);
			bIsSuccess=TestResult(returns.ftpclient,"changedirectory");
			if(!bIsSuccess){
				throw new IOException();
			}
		}
		catch(IOException e){
			returns.bResult=false;
		}
		finally{
			
		}
		
		return returns;
	}

	public static FTPClientListNames ListFiles(FTPClientReturn returns,String strFileName){
		
		FTPClientListNames flReturns=new FTPClientListNames();
		String strFiles[];
		
		try{
			
			boolean bStat;
						
			String strStatus;
			
			returns.bResult=returns.ftpclient.setFileType(FTP.BINARY_FILE_TYPE);
			if(!returns.bResult){
				throw new IOException();
			}
			
			strStatus=returns.ftpclient.getStatus(strFileName);
			bStat=TestResult(returns.ftpclient,"getStatus");
			if(!bStat){
				throw new IOException();
			}
			
			strFiles=returns.ftpclient.listNames(strFileName);
			flReturns.strListNames=strFiles;
			bStat=TestResult(returns.ftpclient,"ListNames");
			if(!bStat){
				
				throw new IOException();
				
			}
		}
		catch(IOException e){
			
			returns.bResult=false;
			
		}
		finally{
			
		}
		flReturns.ftpclient=returns.ftpclient;
		flReturns.bResult=returns.bResult;
		
		return flReturns;
	}
	
	public static FTPClientListNames ListFiles(FTPClientReturn returns){
		
		FTPClientListNames flReturns=new FTPClientListNames();
		String strFiles[];
		
		try{
			
			boolean bStat;
						
			String strStatus;
			
			returns.bResult=returns.ftpclient.setFileType(FTP.BINARY_FILE_TYPE);
			if(!returns.bResult){
				throw new IOException();
			}
			
			/*
			strStatus=returns.ftpclient.getStatus();
			bStat=TestResult(returns.ftpclient,"getStatus");
			if(!bStat){
				throw new IOException();
			}
			*/
			strFiles=returns.ftpclient.listNames();
			flReturns.strListNames=strFiles;
			bStat=TestResult(returns.ftpclient,"ListNames");
			if(!bStat){
				
				throw new IOException();
				
			}
		}
		catch(IOException e){
			
			returns.bResult=false;
			
		}
		finally{
			
		}
		flReturns.ftpclient=returns.ftpclient;
		flReturns.bResult=returns.bResult;
		
		return flReturns;
	}
	
	public static FTPClientReturn RetriveFile(FTPClientReturn returns,String strFromFile,String strToFile){
		
		try{
			File f=new File(strToFile);
			FileOutputStream fo=new FileOutputStream(f);
			returns.bResult=returns.ftpclient.retrieveFile(strFromFile,fo);
		}
		catch(IOException e){
			returns.bResult=false;
		}
		finally{
			
		}
		return returns;
	}
	public static void DownloadFromDirectory(String strFTPServer,String strFTPUserName,String strFTPUserPassWord,String strDirectory,String strToPathPrefix){

		//boolean bReturn;
		int iIndex;
		//String strFiles[];
		String strToFile;
		String strToDirectory;
		String strPWD;
		boolean bIsValid;
		boolean bIsDebug;
		
		bIsDebug=true;
		bIsDebug=false;
		
		FTPClientReturn fr=new FTPClientReturn();
		FTPClientListNames fl=new FTPClientListNames();
		
		try{
			//to path set start
			strToDirectory=strToPathPrefix+"/"+strDirectory;
			bIsValid=MyFileUtility.IsExit(strToDirectory);
			if(bIsValid){
				MyFileUtility.Delete(strToDirectory);
				//MyFileUtility.MkDir(strToDirectory);
			}else{
				//MyFileUtility.MkDir(strToDirectory);
			}
			MyFileUtility.MkDir(strToDirectory);
			//to path set end
			//download from ftp server start
			fr=Connect(strFTPServer);
			fr=Login(fr,strFTPUserName,strFTPUserPassWord);
			fr=ChangeDirectory(fr,strDirectory);
			if(bIsDebug){
				strPWD=fr.ftpclient.printWorkingDirectory();
				System.out.println("current directory is "+strPWD);
			}
			fl=ListFiles(fr);
			fr.ftpclient=fl.ftpclient;
			fr.bResult=fl.bResult;
			for(iIndex=0;iIndex<fl.strListNames.length;iIndex++){
				//System.out.println("file in "+strDirectory+" is "+fl.strListNames[iIndex]);
				strToFile=strToPathPrefix+"/"+strDirectory+"/"+fl.strListNames[iIndex];
				fr=RetriveFile(fr,fl.strListNames[iIndex],strToFile);
			
			}
		}
		catch(IOException e){
			strPWD="";
		}
		finally{
			
		}
		//download from ftp server end
		/*strFiles=fl.strListNames;
		for(iIndex=0;iIndex<strFiles.length;iIndex++){
			System.out.println("strFiles[iIndex] is "+strFiles[iIndex]);
		}*/
		//fr.ftpclient=fl.ftpclient;
		//fr.bResult=fl.bResult;
		//bReturn=fl.bResult;
		fr=MyFTPUtility.Disconnect(fr);
	}
	public static boolean TestResult(FTPClient ftpclient,String strCommand){
		
		boolean bReturn;
		int intReply;
		String strReply;
		
		boolean bIsDebug;
		
		bIsDebug=true;
		bIsDebug=false;
		
		bReturn=true;
		
		intReply=ftpclient.getReplyCode();
		strReply=ftpclient.getReplyString();
		/*if(!FTPReply.isPositiveCompletion(intReply)){
			bReturn=false;
		}*/
		if(FTPReply.isNegativePermanent(intReply)){
			bReturn=false;
		}
		if(FTPReply.isNegativeTransient(intReply)){
			bReturn=false;
		}
		//result display start.
		if(bIsDebug){
			System.out.println("Result of executing "+strCommand);
			System.out.println("reply code is "+intReply);
			System.out.println("reply strings is "+strReply);
			System.out.println("return as boolean is "+bReturn);
		}
		//result display end.
		
		return bReturn;
	}
}
