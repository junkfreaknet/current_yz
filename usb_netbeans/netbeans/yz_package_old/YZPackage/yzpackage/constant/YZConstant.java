/*
 * Created on 2005/03/03
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package yzpackage.constant;

/**
 * @author admnori
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class YZConstant extends Object{

	public static final String JAVAI18NDIRECTORY="JAVA_I18N_Directory_YZ";

	//-----Resource file name
		public static final String I18NGUIResource="I18NGUIResouceYZ";
		public static final String I18NMSGResource="I18NMsgResourceYZ";
		public static final String I18NStringResource="I18NStringResourceYZ";
		// yz application setting file
		public static final String RESOURCEDIRECTORYFORSETTING="d:/JAVA_Setting_Directory_YZ";
		public static final String RESOURCEFILEFORSETTING="Setting.properties";
		//public static final String RESOURCEFILEFORSETTING="Setting";
		
	//-----Keys in resource file
	//----Resource key forYZ Common user interface
		public static final String RESKEYSHIPPINGNO="shippingno";
		public static final String RESKEYSHIPPINGDATEYEAR="year";
		public static final String RESKEYSHIPPINGDATEMONTH="month";
		public static final String RESKEYSHIPPINGDATEDAY="day";
		public static final String RESKEYNOTCONFIRM="notconfirm";
		public static final String RESKEYCONFIRM="confirm";
	
	//-----Resource key for YZ error messages
		//shipping date
		public static final String RESKEYERRORMSGSHIPPINGDATE="errormsgshippingdate";
		//shipping number
		public static final String RESKEYERRORMSGSHIPPINGNO="errormsgshippingno";
		//ftp server error
		public static final String RESKEYERRORMSGFTPSERVER="errormsgftpserver";
		//data is not downloaded 
		public static final String RESKEYERRORMSGDATAISNOTDOWNLOADED="errormsgdataisnotdownloaded";
	//-----Resource key for messages
		public static final String RESKEYMSGEND="msgend";
		
	//-----Resource key for frame title
		//ftp client title
		public static final String RESKEYFRAMETITLEFTPCLIENT="ftpclienttitle";
	
	//-----Resource key about ftp server
		public static final String RESKEYFTPSERVER="ftpserver";
		public static final String RESKEYFTPUSER="ftpuser";
		public static final String RESKEYFTPUSERPASSWORD="ftpueerpassword";
	
	//-----Resource key about ftp server for downloading digital picking data
		public static final String RESKEYFTPSERVERFORPICKING="ftpserverforpicking";
		public static final String RESKEYFTPUSERFORPICKING="ftpuserforpicking";
		public static final String RESKEYFTPUSERPASSWORDFORPICKING="ftpuserpasswordforpicking";
		
	//-----Resource key for local machine resources
		//-----key for path to from ftp servr
		public static final String RESKEYFROMFTP="fromftp";
		//-----key for path to text data
		public static final String RESKEYTOTXT="totxt";
		
	//-----keys in resource file end
	
	
	//prefix of data
	public static final String DATAPREFIXPICKING="DATA";
	
	//shipping number
	public static final String SHIPPINGNO10="10";
	public static final String SHIPPINGNO20="20";
	public static final String SHIPPINGNO30="30";
	public static final String SHIPPINGNO40="40";
	public static final String SHIPPINGNO50="50";
	public static final String SHIPPINGNO60="60";
	public static final String SHIPPINGNO70="70";
	public static final String SHIPPINGNO80="80";
	public static final String SHIPPINGNO90="90";
	
	//internal value definition
	public static final String DATACONFIRM="1";
	public static final String DATANOTCONFIRM="0";
	
	//file name of prefix for digital picking
	public static final String FILENAMEMSUMSF="MSUMSF";
	public static final String FILENAMEHHSEND="HHSEND";
	public static final String FILENAMEMAFILE="MAFILE";
	public static final String FILENAMETTMP="TTMP";
	
	//regulare expression for digital picking data
	public static final String REGEXPMSUMSF="MSUMSF*";
	public static final String REGEXPHHSEND="HHSEND\\d\\d";
	public static final String REGEXPMAFILE="MAFILE\\d\\d";
	public static final String REGEXPTTMP="TTMP\\d\\d";
	
	//record length for digital picking
	public static final String RECORDLENGTHOFMSUMSF="62";
	public static final String RECORDLENGTHOFHHSEND="136";
	public static final String RECORDLENGTHOFMAFILE="252";
	public static final String RECORDLENGTHOFTTMP="252";
	
	
	//
	//*******************************************************************************
	//***tantou-sya master file informations and definitions(from k-server) begin ***
	//*******************************************************************************
	//
	
	//file name
	//public static final String FILENAMETANMS="TANMS";
	//record length
	//public static final String RECORDLENGTHOFTANMS="62";
	//number of fields including tail filler
	//public static final String NUMOFFIELDSTANMS="5";
	//public static final int INT_NUMOFFIELDSTANMS=5;
	
	//public String TANMSFIELDNAME[]=new String[INT_NUMOFFIELDSTANMS];
	//public String TANMSFIELDTYPE[]=new String[INT_NUMOFFIELDSTANMS];
	//public String TANMSFIELDLENGTH[]=new String[INT_NUMOFFIELDSTANMS];
	//public String TANMSFIELDENCODING[]=new String[INT_NUMOFFIELDSTANMS];
	
	/*TANMSFIELDNAME[0]="TANCODE";
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
	TANMSFIELDENCODING[4]="EBCDIC";*/
	
}
