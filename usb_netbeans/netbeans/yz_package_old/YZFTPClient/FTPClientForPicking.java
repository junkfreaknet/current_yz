/*
 * Created on 2005/03/28
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author admnori
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
import yzpackage.gui.*;
import yzpackage.constant.*;
import yzpackage.ftp.download.*;
import yzpackage.dialog.*;
import mypackage.properties.*;


public class FTPClientForPicking extends YZFTPClientWithShippingNo{

	FTPClientForPicking(String strTitle,String strArgPrefix){
		super(strTitle,strArgPrefix);
		//strFTPServer="www.junkfreak.net";
		//strFTPUserName="noriyuki";
		//strFTPUserPassWord="Noriyuki";
		//strToPathPrefix="d:/work/fromftp";
		strFTPServer=MyProperties.GetProperty(YZConstant.RESOURCEDIRECTORYFORSETTING+"/"+YZConstant.RESOURCEFILEFORSETTING,YZConstant.RESKEYFTPSERVERFORPICKING);
		strFTPUserName=MyProperties.GetProperty(YZConstant.RESOURCEDIRECTORYFORSETTING+"/"+YZConstant.RESOURCEFILEFORSETTING,YZConstant.RESKEYFTPUSERFORPICKING);
		strFTPUserPassWord=MyProperties.GetProperty(YZConstant.RESOURCEDIRECTORYFORSETTING+"/"+YZConstant.RESOURCEFILEFORSETTING,YZConstant.RESKEYFTPUSERPASSWORDFORPICKING);
		strToPathPrefix=MyProperties.GetProperty(YZConstant.RESOURCEDIRECTORYFORSETTING+"/"+YZConstant.RESOURCEFILEFORSETTING,YZConstant.RESKEYFROMFTP);
		
	}
	public void yzFrameBasicDoWhenCheckOK(){
	
		//System.out.println("yz ftp client picking data download from ");
		YZFTPDownload.PickingData(strFTPServer,strFTPUserName,strFTPUserPassWord,strPrefix,strYear,strMonth,strDay,strNo,strConfirmOrNot,strToPathPrefix);
		YZDialog.OkOnly(YZConstant.RESKEYMSGEND);
	}
	public static void main(String[] args) {

		//YZFrameBasicWithShippingNoInAction mainframe=new YZFrameBasicWithShippingNoInAction("YZ FTP Client");
		//Pack or set size 
		FTPClientForPicking mainframe=new FTPClientForPicking("YZ FTP Client for Picking",YZConstant.DATAPREFIXPICKING);
		mainframe.setSize(400,400);
		//mainframe.pack();
		mainframe.setVisible(true);
	}
}
