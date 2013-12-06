/*
 * Created on 2005/03/21
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package yzpackage.gui;

import yzpackage.check.gui.YZCheckGUI;
import yzpackage.constant.YZConstant;

/**
 * @author admnori
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class YZFrameBasicWithShippingNoInActionWithCheck extends YZFrameBasicWithShippingNoInAction{

	public String strConfirmOrNot;
	public String strYear;
	public String strMonth;
	public String strDay;
	public String strNo;
	
	public YZFrameBasicWithShippingNoInActionWithCheck(){
		
		super();
		
	}
	
	public YZFrameBasicWithShippingNoInActionWithCheck(String strTitle){
		
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
		strNo=this.txtfShippingNo.getText();
		
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
		
		if(bIsValid){
			bIsValid=YZCheckGUI.CheckShippingNo(strNo);
		}
		return bIsValid;
		
	}
	protected boolean yzFrameBasicInputCheckAdditional(){
		
		boolean bIsValid;
		
		bIsValid=true;
		
		return bIsValid;
		
	}
	public void yzFrameBasicDoWhenCheckOK(){
		
	}
}
