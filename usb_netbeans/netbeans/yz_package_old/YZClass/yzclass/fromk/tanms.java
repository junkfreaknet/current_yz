/*
 * Created on 2006/09/19
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package yzclass.fromk;
//import yzpackage.constant.YZConstant;;
import mypackage.constant.MyConstant;
/**
 * @author admnori
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class tanms {
	//file name
	public static final String FILENAMETANMS="TANMS";
	//record length
	public static final String RECORDLENGTHOFTANMS="62";
	//number of fields including tail filler
	//public static final String NUMOFFIELDSTANMS="5";
	public static final int INT_NUMOFFIELDSTANMS=5;
	
	public String TANMSFIELDNAME[]=new String[INT_NUMOFFIELDSTANMS];
	public String TANMSFIELDTYPE[]=new String[INT_NUMOFFIELDSTANMS];
	public String TANMSFIELDLENGTH[]=new String[INT_NUMOFFIELDSTANMS];
	public String TANMSFIELDENCODING[]=new String[INT_NUMOFFIELDSTANMS];
	
	public tanms(){
		
		TANMSFIELDNAME[0]="TANCODE";
		TANMSFIELDLENGTH[0]="6";
		TANMSFIELDENCODING[0]="EBCDIC";
		
		TANMSFIELDNAME[1]="TANKBN";
		TANMSFIELDLENGTH[1]="2";
		TANMSFIELDENCODING[1]="EBCDIC";
		
		TANMSFIELDNAME[2]="TANNAME1";
		TANMSFIELDLENGTH[2]="12";
		TANMSFIELDENCODING[2]="EBCDIC";
		
		TANMSFIELDNAME[3]="TANNAME2";
		TANMSFIELDLENGTH[3]="12";
		TANMSFIELDENCODING[3]="JIS";
		
		TANMSFIELDNAME[4]="FILLER";
		TANMSFIELDLENGTH[4]="30";
		TANMSFIELDENCODING[4]="EBCDIC";
		
	}
}
