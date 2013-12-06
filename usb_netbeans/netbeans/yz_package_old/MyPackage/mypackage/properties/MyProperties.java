/*
 * Created on 2005/04/20
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package mypackage.properties;
import java.util.*;
import java.io.*;

/**
 * @author admnori
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class MyProperties extends Object{
	
	public static String GetProperty(String strPropertyFile,String strKey){
		
		String strReturn;
		strReturn="";
		
		try{
			//strReturn="";
			Properties pf=new Properties();
			pf.load(new FileInputStream(strPropertyFile));
			strReturn=pf.getProperty(strKey);
			//return strReturn;
		}
		catch(Exception e){
			e.printStackTrace();
			//strReturn="";
		}

		return strReturn;

	}

}
