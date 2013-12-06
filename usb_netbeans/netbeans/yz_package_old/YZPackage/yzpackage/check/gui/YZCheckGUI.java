/*
 * Created on 2005/03/21
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package yzpackage.check.gui;
import yzpackage.check.common.*;
import yzpackage.constant.YZConstant;
import yzpackage.dialog.YZDialog;

/**
 * @author admnori
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class YZCheckGUI extends Object{

	public static boolean CheckShippingDate(String strYear,String strMonth,String strDay){
		
		boolean bReturn;
		
		if(bReturn=YZCheck.CheckShippingDate(strYear,strMonth,strDay)){
			
		}else{
			//date input error dialog
			//System.out.println("shipping date input error.");
			YZDialog.ErrorOkOnly(YZConstant.RESKEYERRORMSGSHIPPINGDATE);
		}
		return bReturn;
	}
	public static boolean CheckShippingNo(String strShippingNo){
		
		boolean bReturn;
		
		if (bReturn=YZCheck.CheckShippingNo(strShippingNo)){
			
			}else{
				//shipping number input error
				//System.out.println("shipping number input error.");
				YZDialog.ErrorOkOnly(YZConstant.RESKEYERRORMSGSHIPPINGNO);
			}
		
		return bReturn;
		
	}
	public static boolean CheckFTPServer(String strFTPServer,String strFTPUserName,String strFTPUserPassWord,String strPreFix,String strYear,String strMonth,String strDay,String strShippingNo,String strConfirm){
		
		boolean bReturn;
		
		bReturn=true;
		
		if(bReturn=YZCheckFTP.IsDataExistOnFTPServer(strFTPServer,strFTPUserName,strFTPUserPassWord,strPreFix,strYear,strMonth,strDay,strShippingNo,strConfirm)){
			//System.out.println("ftp serve access successfull"+strFTPServer+" "+strFTPUserName+" "+strFTPUserPassWord);
		}else{
			//ftp server does not have data dialog	
			//System.out.println("Data is not exist on ftp server.");
			YZDialog.ErrorOkOnly(YZConstant.RESKEYERRORMSGFTPSERVER);
		}
		return bReturn;
		
	}
	public static boolean CheckIsYZDirectoryExist(String strPathToDirectory,String strPrefix,String strYear,String strMonth,String strDay,String strNo,String strConfirmOrNot){
		
		boolean bReturn;
		
		bReturn=true;
		if(bReturn=YZCheck.CheckIsYZDirectoryExist(strPathToDirectory,strPrefix,strYear,strMonth,strDay,strNo,strConfirmOrNot)){
			
		}else{
			YZDialog.ErrorOkOnly(YZConstant.RESKEYERRORMSGDATAISNOTDOWNLOADED);
		}
		
		return bReturn;
		
	}
}
