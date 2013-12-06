/*
 * Created on 2005/03/14
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package mypackage.check.common;
import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.util.*;
import mypackage.util.numeric.*;


/**
 * @author admnori
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class MyCheck extends Object{
	public static boolean CheckDate(String strYear,String strMonth,String strDay){
		
		boolean bReturn;
		
		int iYear;
		int iMonth;
		int iDay;
		
		bReturn=true;
		
		//numeric check
		if(bReturn=CheckNumeric(strYear)){
			if(bReturn=CheckNumeric(strMonth)){
				if(bReturn=CheckNumeric(strDay)){
					
				}else{
					//System.out.println("day error");
				}
			}else{
				//System.out.println("month error.");
			}
		}else{
			//System.out.println("year error.");
		}
		
		//check arguments as calendar
		if(bReturn==true){
			if(bReturn=CheckCalendar(MyUtilNumeric.GetIntFromDecimalFormat(strYear),MyUtilNumeric.GetIntFromDecimalFormat(strMonth),MyUtilNumeric.GetIntFromDecimalFormat(strDay))){
				
			}else{
				//System.out.println("Year");
				//System.out.println(strYear);
				//System.out.println("Month");
				//System.out.println(strMonth);
				//System.out.println("Day");
				//System.out.println(strDay);
				System.out.println("Canlendar error");
			}
		}
		
		return bReturn;
		
	}
	public static boolean CheckNumeric(String strNumber){
		
		boolean bReturn;
		final int conIntStartPos=0;
		
		DecimalFormat df=new DecimalFormat();
		ParsePosition pp=new ParsePosition(conIntStartPos);
		
		bReturn=true;
		
		try{
			Number nb=df.parse(strNumber,pp);
			if(nb==null){
				
				bReturn=false;
				
			}
		}
		
		catch(NullPointerException e){
			bReturn=false;
		}
		
		return bReturn;
		
	}
	public static boolean CheckCalendar(int intYear,int intMonth,int intDay){
		
		boolean bReturn;

		Calendar cl=new GregorianCalendar(intYear,intMonth - 1,intDay);
		
		bReturn=true;
		
		//modified 2005.12.06 begin
		intMonth=intMonth-1;
		//modified 2005.12.06 end
		
		if(cl.get(Calendar.YEAR)!=intYear
				|cl.get(Calendar.MONTH)!=intMonth
				|cl.get(Calendar.DATE)!=intDay){
			bReturn=false;
		}
		
		//System.out.println("in Check Calendar Year");
		//System.out.println(intYear);
		//System.out.println("in Check Calendar Month");
		//System.out.println(intMonth);
		//System.out.println("in Check Calendar Day");
		//System.out.println(intDay);
		return bReturn;
		
	}

}
