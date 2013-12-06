/*
 * Created on 2005/03/09
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package mypackage.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author admnori
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class MyI18NUtility extends Object{
	public static String getString(String strLanguage,String strCountry,String strBaseName,String strKey){
		
		String strResult;
		Locale locale;

		locale=new Locale(strLanguage,strCountry);
		ResourceBundle rb = ResourceBundle.getBundle(strBaseName , locale);
		strResult=rb.getString(strKey);
		return strResult;
		
	}

}
