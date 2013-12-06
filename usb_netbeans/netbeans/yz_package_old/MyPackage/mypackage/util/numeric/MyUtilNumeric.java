/*
 * Created on 2005/03/16
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package mypackage.util.numeric;

import java.text.DecimalFormat;
import java.text.ParsePosition;

/**
 * @author admnori
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class MyUtilNumeric extends Object{

	public static int GetIntFromDecimalFormat(String strNumber){
		
		int iReturn;
		
		final int conIntStartPos=0;
		DecimalFormat df=new DecimalFormat();
		ParsePosition pp=new ParsePosition(conIntStartPos);
		
		iReturn=0;
		
		try{
			Number nb=df.parse(strNumber,pp);
			if(nb!=null){
				
				iReturn=nb.intValue();
				
			}
		}
		
		catch(NullPointerException e){
			
		}
		
		return iReturn;
		
	}
}
