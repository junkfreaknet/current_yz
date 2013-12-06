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
public class FTPClient2 extends YZFrameBasicWithShippingNoInActionWithCheck{

	public FTPClient2(){
		super();
	}
	public FTPClient2(String strTitle){
		super(strTitle);
	}
	
	public static void main(String[] args) {

		//YZFrameBasicWithShippingNoInAction mainframe=new YZFrameBasicWithShippingNoInAction("YZ FTP Client");
		//Pack or set size 
		FTPClient2 mainframe=new FTPClient2("YZ FTP Client");
		mainframe.setSize(400,400);
		//mainframe.pack();
		mainframe.setVisible(true);
	}
}
