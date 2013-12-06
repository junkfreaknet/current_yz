/*
 * Created on 2005/03/16
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package yzpackage.check.common;
import mypackage.check.ftp.*;
import yzpackage.util.*;


/**
 * @author admnori
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class YZCheckFTP extends Object{

	public static boolean IsDataExistOnFTPServer(String strPreFix,String strYear,String strMonth,String strDay,String strShippingNo,String strConfirm){
		
		boolean bReturn;
		
		bReturn=true;
		
		return bReturn;
		
	}
	public static boolean IsDataExistOnFTPServer(String strPreFix,String strYear,String strMonth,String strDay){
		
		boolean bReturn;
		
		bReturn=true;
		
		return bReturn;
		
	}
	public static boolean IsDataExistOnFTPServer(String strFTPServer,String strFTPUserName,String strFTPPassWord,String strPreFix,String strYear,String strMonth,String strDay,String strShippingNo,String strConfirm){
		
		boolean bReturn;
		
		bReturn=true;
		bReturn=IsDataExistOnFTPServerCommon(strFTPServer,strFTPUserName,strFTPPassWord,strPreFix,strYear,strMonth,strDay,strShippingNo,strConfirm);
		return bReturn;
		
	}
	public static boolean IsDataExistOnFTPServerCommon(String strFTPServer,String strFTPUserName,String strFTPPassWord,String strPreFix,String strYear,String strMonth,String strDay,String strShippingNo,String strConfirm){
		
		boolean bReturn;
		//bReturn=true;
		String strDirectory;
		
		//strDirectory=strPreFix+strYear+strMonth+strDay+strShippingNo+strConfirm;
		strDirectory=YZUtility.MakeDirectoryString(strPreFix,strYear,strMonth,strDay,strShippingNo,strConfirm);
		
		//System.out.println(strDirectory);
		
		bReturn=MyCheckFTP.IsFTPServerExist(strFTPServer,strFTPUserName,strFTPPassWord);
		
		if(bReturn){
			bReturn=MyCheckFTP.IsDirectoryExist(strFTPServer,strFTPUserName,strFTPPassWord,strDirectory);
		}
		//System.out.println("from IsDataExistFTPServerCommon "+bReturn);
		return bReturn;
		
	}
}
