/*
 * Created on 2005/03/27
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package mypackage.check.ftp;
import myclass.ftp.*;
import mypackage.ftp.utility.*;

/**
 * @author admnori
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class MyCheckFTP extends Object{

	public static boolean IsFTPServerExist(String strFTPServer,String strFTPUserName,String strFTPPassWord){
		
		FTPClientReturn fr=new FTPClientReturn();
		
		fr=MyFTPUtility.Connect(strFTPServer);
				
		if(fr.bResult){
			
			fr=MyFTPUtility.Login(fr,strFTPUserName,strFTPPassWord);
					
		}
		
		if(fr.bResult){
			
			fr=MyFTPUtility.Disconnect(fr);
			
		}
		return fr.bResult;
		
	}
	
	public static boolean IsDirectoryExist(String strFTPServer,String strFTPUserName,String strFTPPassWord,String strDirectory){

		boolean bReturn;
		
		FTPClientReturn fr=new FTPClientReturn();
		FTPClientListNames fl=new FTPClientListNames();
		
		fr=MyFTPUtility.Connect(strFTPServer);
		fr=MyFTPUtility.Login(fr,strFTPUserName,strFTPPassWord);
		fl=MyFTPUtility.ListFiles(fr,strDirectory);
		fr.ftpclient=fl.ftpclient;
		fr.bResult=fl.bResult;
		bReturn=fl.bResult;
		fr=MyFTPUtility.Disconnect(fr);
		return bReturn;
	
	}
}
