/*
 * Created on 2005/03/28
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package yzpackage.ftp.download;
import mypackage.ftp.utility.*;
import yzpackage.util.*;
//import yzpackage.constant.*;
//import yzpackage.dialog.*;


/**
 * @author admnori
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
	
public class YZFTPDownload extends Object{
	
	public static void PickingData(String strFTPServer,String strFTPUserName,String strFTPUserPassWord,String strPreFix,String strYear,String strMonth,String strDay,String strShippingNo,String strConfirm,String strToPathPrefix){
		
		//boolean bReturn;
		String strDirectory;

		//strDirectory=strPreFix+strYear+strMonth+strDay+strShippingNo+strConfirm;
		strDirectory=YZUtility.MakeDirectoryString(strPreFix,strYear,strMonth,strDay,strShippingNo,strConfirm);
		//System.out.println("strDirectory is "+strDirectory);
		MyFTPUtility.DownloadFromDirectory(strFTPServer,strFTPUserName,strFTPUserPassWord,strDirectory,strToPathPrefix);
	}
	/***
	public static void PickingDataWithDialog(String strFTPServer,String strFTPUserName,String strFTPUserPassWord,String strPreFix,String strYear,String strMonth,String strDay,String strShippingNo,String strConfirm,String strToPathPrefix){
		
		boolean bReturn;
		String strDirectory;

		strDirectory=strPreFix+strYear+strMonth+strDay+strShippingNo+strConfirm;
		strDirectory=YZUtility.MakeDirectoryString(strPreFix,strYear,strMonth,strDay,strShippingNo,strConfirm);
		System.out.println("strDirectory is "+strDirectory);
		MyFTPUtility.DownloadFromDirectory(strFTPServer,strFTPUserName,strFTPUserPassWord,strDirectory,strToPathPrefix);
		YZDialog.OkOnly(YZConstant.RESKEYMSGEND);
		
	}
	***/
}
