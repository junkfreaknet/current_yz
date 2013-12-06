/*
 * Created on 2005/03/21
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package yzpackage.gui;

//import yzpackage.check.common.YZCheck;
import yzpackage.check.gui.*;
//import yzpackage.constant.YZConstant;
//import yzpackage.dialog.YZDialog;

/**
 * @author admnori
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class YZFrameBasicInActionWithCheck extends YZFrameBasicInAction{
	
	//boolean bIsValid;
	//boolean bIsTest;
	//String strConfirmOrNot;
	String strYear;
	String strMonth;
	String strDay;
	
	public YZFrameBasicInActionWithCheck(){
		
		super();
	
	}
	public YZFrameBasicInActionWithCheck(String strTitle){
		
		super(strTitle);
		
	}
	
	protected void yzFrameBasicClickOk(){
		
		boolean bIsValid;
		boolean bIsTest;
		
		//bIsTest=true;
		bIsTest=false;
		strYear=this.txtfShippingDateYYYY.getText();
		strMonth=this.txtfShippingDateMM.getText();
		strDay=this.txtfShippingDateDD.getText();
		
		if(bIsTest){
			System.out.println("OK clicked.");
			System.out.println("year is            "+strYear);
			System.out.println("month is           "+strMonth);
			System.out.println("day is             "+strDay);
		}
		
		if(bIsValid=yzFrameBasicInputCheck()){
			
			yzFrameBasicDoWhenCheckOK();
			
		}
		
	}
	protected boolean yzFrameBasicInputCheck(){
		
		boolean bIsValid;
		
		bIsValid=true;
		
		bIsValid=yzFrameBasicInputCheckCommon();
		if(bIsValid){
			bIsValid=yzFrameBasicInputCheckAdditional();
		}
		return bIsValid;
		
	}
	protected boolean yzFrameBasicInputCheckCommon(){
		
		boolean bIsValid;
		
		bIsValid=YZCheckGUI.CheckShippingDate(strYear,strMonth,strDay);
		
		return bIsValid;
		
	}
	protected boolean yzFrameBasicInputCheckAdditional(){
		
		boolean bIsValid;
		
		bIsValid=true;
		
		return bIsValid;
		
	}
	protected void yzFrameBasicDoWhenCheckOK(){
		
	}
}
