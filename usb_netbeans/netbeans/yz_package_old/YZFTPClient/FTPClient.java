/*
 * Created on 2005/01/29
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
//import yzpackage.i18n.YZI18NUtility;
import yzpackage.check.common.*;
import yzpackage.constant.YZConstant;
import yzpackage.dialog.*;
//import mypackage.dialog.*;

//import java.awt.*;

public class FTPClient extends YZFrameBasicWithShippingNoInAction{
	
	public FTPClient(){
		
		super();
		
	}
	public FTPClient(String strTitle){
		
		super(strTitle);
		
	}
	//when "ok" button is clicked.
	protected void yzFrameBasicClickOk(){
		
		boolean bIsValid;
		boolean bIsTest;
		String strConfirmOrNot;
		
		//check flag set and temporary steps BEGIN
		bIsTest=false;
		//bIsTest=true;
		
		final String strFTPServer="www.junkfreak.net";
		final String strFTPUserName="noriyuki";
		final String strFTPUserPassWord="Noriyuki";
		
		//check flag set and temporary steps END
		
		String strYear=this.txtfShippingDateYYYY.getText();
		String strMonth=this.txtfShippingDateMM.getText();
		String strDay=this.txtfShippingDateDD.getText();
		String strNo=this.txtfShippingNo.getText();
		
		if(this.cbxConfirm.getState()){	
			strConfirmOrNot=YZConstant.DATACONFIRM;
		}else{
			strConfirmOrNot=YZConstant.DATANOTCONFIRM;
		}
		
		if(bIsTest){
			System.out.println("OK clicked.");
			System.out.println("year is            "+strYear);
			System.out.println("month is           "+strMonth);
			System.out.println("day is             "+strDay);
			System.out.println("Shipping number is "+strNo);
			System.out.println("confirm is         "+strConfirmOrNot);
		}
		
		//shipping date input check
		if(bIsValid=YZCheck.CheckShippingDate(strYear,strMonth,strDay)){
			
		}else{
			//date input error dialog
			//System.out.println("shipping date input error.");
			YZDialog.ErrorOkOnly(YZConstant.RESKEYERRORMSGSHIPPINGDATE);
		}
		
		//shipping number input check
		if(bIsValid){
			if (bIsValid=YZCheck.CheckShippingNo(strNo)){
			
			}else{
				//shipping number input error
				//System.out.println("shipping number input error.");
				YZDialog.ErrorOkOnly(YZConstant.RESKEYERRORMSGSHIPPINGNO);
			}
		}
		
		//data exist check
		if(bIsValid){
			if(bIsValid=YZCheckFTP.IsDataExistOnFTPServer(strFTPServer,strFTPUserName,strFTPUserPassWord,YZConstant.DATAPREFIXPICKING,strYear,strMonth,strDay,strNo,strConfirmOrNot)){
				System.out.println("ftp serve access successfull"+strFTPServer+" "+strFTPUserName+" "+strFTPUserPassWord);
			}else{
				//ftp server does not have data dialog	
				System.out.println("Data is not exist on ftp server.");
			}
		}
		
		//doanload data if all checks ok.
		if(bIsValid){
			System.out.println("OK I'll download data ");
		}
		
	}
	
	//when "cancel" button is clicked.
	/*protected void yzFrameBasicClickCancel(){	
		
		super.yzFrameBasicCommonCancelClicked();
		this.cbxNotConfirm.setState(true);
		
	}*/
	
	//yz ftp client main
	public static void main(String[] args) {

		//YZFrameBasicWithShippingNoInAction mainframe=new YZFrameBasicWithShippingNoInAction("YZ FTP Client");
		//Pack or set size 
		FTPClient mainframe=new FTPClient("YZ FTP Client");
		mainframe.setSize(400,400);
		//mainframe.pack();
		mainframe.setVisible(true);
		
	}
}
