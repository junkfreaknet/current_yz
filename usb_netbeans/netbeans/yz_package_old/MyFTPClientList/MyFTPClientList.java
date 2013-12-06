/*
 * Created on 2005/01/22
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
//import org.apache.commons.net.*;
import org.apache.commons.net.ftp.*;

public class MyFTPClientList {
		public static String command;
		public static String routine;
		public static String para001;
		public static String para002;	
		public static String para003;
		public static String para004;
		public static String para005;
		
	public static void main(String[] args) {
		//common definition for every classes
		final String classname="MyFTPClientList";

		
		//
		FTPClient ftpcnt=new FTPClient();
		boolean issuccess;
		issuccess=true;
		
		try{
			String server;
			String username;
			String password;
			String directory;
			String status;
			String[] statuses;
			
			int reply;
			command="";
			
			server="www.junkfreak.net";
			username="noriyuki";
			password="Noriyuki";
			
			//Immediately after connecting ftp server,
			//you should check status from ftp server.
			//Terminate this program if connecting faied.
			ftpcnt.connect(server);
			System.out.println(classname+" Connecting"+server+".");
			System.out.println(classname+" "+ftpcnt.getReplyString());
			
			reply=ftpcnt.getReplyCode();
			if(!FTPReply.isPositiveCompletion(reply)){
				//ftpcnt.disconnect();
				System.out.println(classname+" "+"FTP server refused connection.");
				System.exit(1);
			}else{
				command="login";
				if(issuccess=ftpcnt.login(username,password)){
					
					command="set_file_type";
					if(issuccess=ftpcnt.setFileType(FTP.BINARY_FILE_TYPE)){
						command="listFiles";
						directory="ddd";
						status=ftpcnt.getStatus(directory);
						System.out.println("ststus for "+directory+" is ");
						System.out.println(status);
						String[] files=ftpcnt.listNames(directory);
						reply=ftpcnt.getReplyCode();
						System.out.println("reply code from getReplyCode()");
						System.out.println(reply);
						status=ftpcnt.getReplyString();
						System.out.println("status string from getReplyString() ");
						System.out.println(status);
						statuses=ftpcnt.getReplyStrings();
						System.out.println("status string from getReplyStrings() ");
						System.out.println(statuses);
						
						//System.out.println(files.length); ... to be purged
						//if(files[0]==null){
							//System.out.println(classname+" "+directory+" is not exist.");
						//}else{

						if((reply=ftpcnt.getReplyCode())==550){
							//System.out.println("No files in " +directory+" or");
							//System.out.println("Directory "+directory+" is not found.");
						}else{
							//for(int i=0;i<files.length;i++){
								//System.out.println(files[i]);
							//}
						}
						//}
					}else{
						
					}
					
					//At last logout...
					command="logout";
					issuccess=ftpcnt.logout();				
				}else{
					System.out.println(classname+" login failed.");
					System.out.println("ftp server is "+server+".");
					System.out.println("user name  is "+username+".");
					System.out.println("password   is "+ password+".");
				}
			}
		}
		catch(IOException e){
			System.out.println("IOException caused.");
			System.out.println("in command "+command);
			//force set false
			issuccess=false;
		}
		finally{
			try{
				if(ftpcnt.isConnected()){
					ftpcnt.disconnect();
				}
				if(issuccess){
					System.out.println(classname+" has been finished successfully.");
				}else{
					System.out.println(classname+" has been finished with some error.");
				}
			}
			catch(IOException e){
				
			}
		}
	}
}
