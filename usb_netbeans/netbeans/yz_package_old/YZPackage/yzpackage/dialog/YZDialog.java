/*
 * Created on 2005/03/21
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package yzpackage.dialog;
import yzpackage.i18n.*;
import yzpackage.constant.*;
import mypackage.constant.*;
import mypackage.dialog.*;

/**
 * @author admnori
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class YZDialog extends Object{
	
	public static void OkOnly(String strResourceKey){

		String strFrameTitle=YZI18NUtility.getString(YZConstant.I18NStringResource,YZConstant.RESKEYFRAMETITLEFTPCLIENT);
		String strDialogTitle=YZI18NUtility.getString(MyConstant.I18NStringResource,MyConstant.RESKEYDIALOGTITLEFORCOMMON);
		String strErrorMsg=YZI18NUtility.getString(YZConstant.I18NMSGResource,strResourceKey);
		
		MyDialog.ErrorDialog(strFrameTitle,strDialogTitle,strErrorMsg);
		
	}

	public static void ErrorOkOnly(String strResourceKey){
		
		String strFrameTitle=YZI18NUtility.getString(YZConstant.I18NStringResource,YZConstant.RESKEYFRAMETITLEFTPCLIENT);
		String strDialogTitle=YZI18NUtility.getString(MyConstant.I18NStringResource,MyConstant.RESKEYDIALOGTITLEFORERROR);
		String strErrorMsg=YZI18NUtility.getString(YZConstant.I18NMSGResource,strResourceKey);
		
		MyDialog.ErrorDialog(strFrameTitle,strDialogTitle,strErrorMsg);
		
	}
}
