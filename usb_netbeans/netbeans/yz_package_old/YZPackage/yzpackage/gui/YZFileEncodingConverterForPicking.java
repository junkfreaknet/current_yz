/*
 * Created on 2005/04/19
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package yzpackage.gui;

//import yzpackage.check.gui.YZCheckGUI;
import yzpackage.check.gui.*;

/**
 * @author admnori
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class YZFileEncodingConverterForPicking extends YZFrameBasicWithShippingNoInActionWithCheck{
	
	public String strPathToFromFTP;
	public String strPathToTXT;
	public String strPrefix;
	
	public YZFileEncodingConverterForPicking(){
		super();
	}
	public YZFileEncodingConverterForPicking(String strTitle){
		
		super(strTitle);
		
	}
	public YZFileEncodingConverterForPicking(String strTitle,String strArgPrefix){
		
		super(strTitle);
		strPrefix=strArgPrefix;
		
	}
	protected boolean yzFrameBasicInputCheckAdditional(){
		
		boolean bReturn;
		
		bReturn=YZCheckGUI.CheckIsYZDirectoryExist(strPathToFromFTP,strPrefix,strYear,strMonth,strDay,strNo,strConfirmOrNot);
		return bReturn;
		
	}

}
