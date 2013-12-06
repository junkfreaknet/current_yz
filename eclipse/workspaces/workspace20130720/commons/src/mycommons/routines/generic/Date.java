package mycommons.routines.generic;

//import java.util.Locale;

public class Date {
	
	//
	//argument "date" must to be a "yyyy/mm/dd" or "yyyymmdd" format 
	//value.
	//
	public static String getWeekday(String date,java.util.Locale locale){
		
		java.util.Calendar calendar=new java.util.GregorianCalendar(mycommons.routines.generic.Date.getYear(date),mycommons.routines.generic.Date.createValueOfMonth(mycommons.routines.generic.Date.getMonth(date)),mycommons.routines.generic.Date.getDay(date));	
		java.text.SimpleDateFormat weekday=new java.text.SimpleDateFormat("EE", locale);
		java.util.Date dte=calendar.getTime();
		return weekday.format(dte);
		
	}
	public static int getWeekday(String date){
		 
		java.util.Calendar calendar=new java.util.GregorianCalendar(mycommons.routines.generic.Date.getYear(date),mycommons.routines.generic.Date.createValueOfMonth(mycommons.routines.generic.Date.getMonth(date)),mycommons.routines.generic.Date.getDay(date));		
		
		return calendar.get(java.util.Calendar.DAY_OF_WEEK);
			
	}
	public static int getYear(String date){
		
		int rv=mycommons.constants.Generic.CS_ZERO_AS_INT;
		
		date=mycommons.routines.generic.Convert.returnYYYYMMDD(date);
		date=date.substring(mycommons.constants.Generic.CS_ZERO_AS_INT, mycommons.constants.Generic.CS_LEN_DATE_Year_4);
		rv=Integer.valueOf(date);
		
		return rv;
	}
	public static int getMonth(String date){
		
		int rv=mycommons.constants.Generic.CS_ZERO_AS_INT;
		
		date=mycommons.routines.generic.Convert.returnYYYYMMDD(date);
		date=date.substring(mycommons.constants.Generic.CS_LEN_DATE_Year_4,mycommons.constants.Generic.CS_LEN_DATE_Year_4+ mycommons.constants.Generic.CS_LEN_DATE_Month);
		rv=Integer.valueOf(date);
		
		return rv;
		
	}
	public static int createValueOfMonth(int month){
		return month-mycommons.constants.Generic.CS_1_AS_INT;
	}
	public static int getDay(String date){
		
		int rv=mycommons.constants.Generic.CS_ZERO_AS_INT;
		
		date=mycommons.routines.generic.Convert.returnYYYYMMDD(date);
		date=date.substring(mycommons.constants.Generic.CS_LEN_DATE_Year_4+mycommons.constants.Generic.CS_LEN_DATE_Month, mycommons.constants.Generic.CS_LEN_DATE_Year_4+mycommons.constants.Generic.CS_LEN_DATE_Month+mycommons.constants.Generic.CS_LEN_DATE_Day);
		rv=Integer.valueOf(date);
		
		return rv;
				
	}

}
