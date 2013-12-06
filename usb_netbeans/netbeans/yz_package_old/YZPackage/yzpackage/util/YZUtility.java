/*
 * Created on 2005/04/23
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package yzpackage.util;

/**
 * @author admnori
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class YZUtility extends Object{
	
	public static String MakeDirectoryString(String strPath,String strPrefix,String strYear,String strMonth,String strDay,String strNo,String strConfirmOrNot){
		
		String strReturn;
		strReturn=strPath+"/"+strPrefix+strYear+strMonth+strDay+strNo+strConfirmOrNot;
		return strReturn;
		
	}
	public static String MakeDirectoryString(String strPrefix,String strYear,String strMonth,String strDay,String strNo,String strConfirmOrNot){
		
		String strReturn;
		strReturn=strPrefix+strYear+strMonth+strDay+strNo+strConfirmOrNot;
		return strReturn;
		
	}
}
