/*
 * Created on 2005/03/03
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package mypackage.constant;

/**
 * @author admnori
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class MyConstant extends Object{
	
	//Constant for not finding System.genenv("xxx")
	public static final String GETENVNOTFOUND=null;
	
	//paramater name for path of I18N resource file
	public static final String JAVAI18NDIRECTORY="JAVA_I18N_Directory_Common";
	public static final String I18NGUIResource="I18NGUIResourceCommon";
	public static final String I18NMsgResource="I18NMsgResourceCommon";
	public static final String I18NStringResource="I18NStringResourceCommon";
	
	//Resource key for common frame.
	//menu
	public static final String RESKEYFILE="file";
	public static final String RESKEYHELP="help";
	public static final String RESKEYOPEN="open";
	public static final String RESKEYQUIT="quit";
	public static final String RESKEYABOUT="about";
	//button
	public static final String RESKEYOK="ok";
	public static final String RESKEYCANCEL="cancel";
	public static final String RESKEYEND="end";
	
	//-----Resource key for dialog title
		//error dialog title
		public static final String RESKEYDIALOGTITLEFORCOMMON="dialogtitleforcommon";
		public static final String RESKEYDIALOGTITLEFORERROR="dialogtitleforerror";

//--------- info  from K server
		
	//-----file encoding type
		public static final String ENCODINGDEFAULT="default";
		public static final String ENCODINGEBCDIC="EBCDIC";
		public static final String ENCODINGJIS="JIS";
	
	//-----field type 
		public static final String FIELDTYPEALPAHBETIC="alphabetic";
		public static final String FIELDTYPENUMERIC="numeric";
		
}
