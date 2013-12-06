/*
 * Created on 2005/03/21
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package yzpackage.gui;

//import yzpackage.check.common.YZCheckFTP;
//import yzpackage.constant.YZConstant;
import yzpackage.check.gui.*;

/**
 * @author admnori
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class YZFTPClientWithShippingNo extends YZFrameBasicWithShippingNoInActionWithCheck{

	public String strFTPServer;
	public String strFTPUserName;
	public String strFTPUserPassWord;
	public String strToPathPrefix;
	
	//final String strFTPUserPassWord="horiemon";
	
	public String strPrefix;
	
	public YZFTPClientWithShippingNo(){
		super();
	}
	public YZFTPClientWithShippingNo(String strArgPrefix){
		super();
		strPrefix=strArgPrefix;
	}
	public YZFTPClientWithShippingNo(String strTitle,String strArgPrefix){
		super(strTitle);
		strPrefix=strArgPrefix;
	}
	protected boolean yzFrameBasicInputCheckAdditional(){
		
		boolean bReturn;
		
		bReturn=yzFrameBasicFTPCheck();
		
		return bReturn;
		
	}
	protected boolean yzFrameBasicFTPCheck(){
		
		boolean bReturn;
		
		bReturn=YZCheckGUI.CheckFTPServer(strFTPServer,strFTPUserName,strFTPUserPassWord,strPrefix,strYear,strMonth,strDay,strNo,strConfirmOrNot);
		//System.out.println("bReturn is "+bReturn);
		return bReturn;
		
	}
	
}
