/*
 * Created on 2005/01/16
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
/******************* Author's comment ******************************
 This is a my first experimental program for ftp client.
 
 1. It depends on package from Apache Foundation.
 	see jakarta subproject --->commons-net.ftp
 2. Execute as main class.
 
******************** Author's comment end **************************/

import java.io.*;
import org.apache.commons.net.ftp.*;

public class MyFTPClient {

	public static void main(String[] args) {
		
		//program main sectin
		FTPClient ftpcnt=new FTPClient();
		boolean issuccess;
		issuccess=true;
		
		try{
			//declare
			String server;
			String username;
			String password;
			String tofilename;
			String fromfilename;
			
			//String account;
			
			int reply;
			//boolean functionresult;
			//boolean issuccess;
			
			//Connect ftp server.			
			//FTPClient ftpcnt = new FTPClient();
			server="1.3.3.40";
			username="KTAN";
			password="KTAN";
			server="www.junkfreak.net";
			username="noriyuki";
			password="Noriyuki";
			//account="KTAN";
			
			ftpcnt.connect(server);
			System.out.println("Connecting "+server+".");
			System.out.println(ftpcnt.getReplyString());
			
			//Connect to server successfull or fault.
			//Program should check reply code from ftp server.
			reply=ftpcnt.getReplyCode();
			if(!FTPReply.isPositiveCompletion(reply)){
				ftpcnt.disconnect();
				System.out.println("FTP server refused connection.");
				System.exit(1);
			}
			
			//login & transfer file from ftp server
			issuccess=ftpcnt.login(username,password);
			if(issuccess){
				System.out.println("MyFTPClient login successfull.");
				tofilename="fromftpserver";
				fromfilename="fromserver";
				fromfilename="toclient";
				File f=new File(tofilename);
				FileOutputStream fo=new FileOutputStream(f);
				issuccess=ftpcnt.retrieveFile(fromfilename,fo);
				//***
				//FTPFile[] files=ftpcnt.listFiles();
				
				
				if(issuccess){
					System.out.println("MyFTPClient retrieving file finished successfull.");
					System.out.println("from "+fromfilename+" -----> to "+tofilename+".");				
				}else
				{
					System.out.println("MyFTPClient retrieving file failed.");
					System.out.println("from "+fromfilename+" -----> to "+tofilename+".");
				}
			//at last logout
				issuccess=ftpcnt.logout();
			}else
			{
				System.out.println("MyFTPClient login failed.");
			}
			
		}
		catch(IOException e){
			System.out.println("Error!!");
			System.out.println("Connecting to ftp server failed.");
			//return;
		}
		//program end section
		finally{
			try{
				if(ftpcnt.isConnected()){
					//ftpcnt.logout();
					ftpcnt.disconnect();
				}
				if(issuccess){
					System.out.println("MyFTPClient finished successfull.");
				}else
				{
					System.out.println("MyFTPClient failed.");
				}
			}
			catch(IOException e){
				
			}
		}
		
	}
}
