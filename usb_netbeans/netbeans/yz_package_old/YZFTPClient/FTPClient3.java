/*
 * Created on 2005/03/21
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


public class FTPClient3 extends YZFTPClientWithShippingNo{

	FTPClient3(String strTitle,String strArgPrefix){
		super(strTitle,strArgPrefix);
	}
	public static void main(String[] args) {

		//YZFrameBasicWithShippingNoInAction mainframe=new YZFrameBasicWithShippingNoInAction("YZ FTP Client");
		//Pack or set size 
		FTPClient3 mainframe=new FTPClient3("YZ FTP Client for Picking",YZConstant.DATAPREFIXPICKING);
		mainframe.setSize(400,400);
		//mainframe.pack();
		mainframe.setVisible(true);
	}
}
