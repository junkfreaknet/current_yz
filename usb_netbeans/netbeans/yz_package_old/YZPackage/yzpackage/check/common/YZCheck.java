/*
 * Created on 2005/03/14
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package yzpackage.check.common;
import yzpackage.constant.*;
import yzpackage.util.*;
import mypackage.check.common.*;
import mypackage.file.utility.*;

/**
 * @author admnori
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class YZCheck extends Object{

	public static boolean CheckShippingDate(String strYear,String strMonth,String strDay){
		
		boolean bReturn;
		//bReturn=true;
		
		bReturn=MyCheck.CheckDate(strYear,strMonth,strDay);
		
		return bReturn;
		
	}
	public static boolean CheckShippingNo(String strShippingNo){
		
		boolean bReturn;
		
		bReturn=true;
		
		//check begin
		if(strShippingNo.equals(YZConstant.SHIPPINGNO10)){}else{
			if(strShippingNo.equals(YZConstant.SHIPPINGNO20)){}else{
				if(strShippingNo.equals(YZConstant.SHIPPINGNO30)){}else{
					if(strShippingNo.equals(YZConstant.SHIPPINGNO40)){}else{
						if(strShippingNo.equals(YZConstant.SHIPPINGNO50)){}else{
							if(strShippingNo.equals(YZConstant.SHIPPINGNO60)){}else{
								if(strShippingNo.equals(YZConstant.SHIPPINGNO70)){}else{
									if(strShippingNo.equals(YZConstant.SHIPPINGNO80)){}else{
										if(strShippingNo.equals(YZConstant.SHIPPINGNO90)){}else{
											bReturn=false;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		//check end
		
		return bReturn;
		
	}
	
	public static boolean CheckIsYZDirectoryExist(String strPathToDirectory,String strPrefix,String strShippingYear,String strShippingMonth,String strShippingDay,String strShippingNo,String strConfirmOrNot){
		
		boolean bReturn;
		String strDirectory;
		
		bReturn=true;
		
		//strDirectory=strPathToDirectory+"/"+strPrefix+strShippingYear+strShippingMonth+strShippingDay+strShippingNo+strConfirmOrNot;
		strDirectory=YZUtility.MakeDirectoryString(strPathToDirectory,strPrefix,strShippingYear,strShippingMonth,strShippingDay,strShippingNo,strConfirmOrNot);
		bReturn=MyFileUtility.IsExit(strDirectory);
		
		return bReturn;
	}
}
