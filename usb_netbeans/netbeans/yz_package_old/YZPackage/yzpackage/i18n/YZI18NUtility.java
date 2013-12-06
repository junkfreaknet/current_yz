/*
 * Created on 2005/03/09
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package yzpackage.i18n;

import java.util.Locale;

import mypackage.i18n.*;

/**
 * @author admnori
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class YZI18NUtility extends Object{
	public static String getString(String strBaseName,String strKey){
		
		String strReturn;
		String strLanguage;
		String strCountry;
		
		Locale locale=Locale.getDefault();
		strLanguage=locale.getLanguage();
		strCountry=locale.getCountry();
		
		strReturn=MyI18NUtility.getString(strLanguage,strCountry,strBaseName,strKey);
		return strReturn;

	}
}
