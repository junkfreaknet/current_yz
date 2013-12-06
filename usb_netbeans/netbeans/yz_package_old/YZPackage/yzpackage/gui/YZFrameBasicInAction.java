/*
 * Created on 2005/03/21
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package yzpackage.gui;
import java.awt.Component;
import java.awt.Event;

import mypackage.gui.*;
/**
 * @author admnori
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class YZFrameBasicInAction extends yzframebasic{
	
	Component cmpFirst;
	
	public YZFrameBasicInAction(){
		
		super();
		yzFrameBasicSetFirstItem();
	}
	public YZFrameBasicInAction(String strTitle){
		
		super(strTitle);
		yzFrameBasicSetFirstItem();
	}
	protected void yzFrameBasicSetFirstItem(){
		
		cmpFirst=txtfShippingDateYYYY;
	
	}
	
	public boolean action(Event e,Object arg){
		
		boolean blResult;
		
		blResult=false;
	
		if(e.target==btnOk){
			blResult=true;
			yzFrameBasicClickOk();	
		}
		if(e.target==btnCancel){
			blResult=true;
			yzFrameBasicClickCancel();	
		}
		if(e.target==btnEnd){
			blResult=true;
			yzFrameBasicClickEnd();	
		}
		if(e.target==mniQuit){
			blResult=true;
			yzFrameBasicClickEnd();	
		}
		
		return blResult;
	}
	protected void yzFrameBasicClickOk(){
		
	}
	protected void yzFrameBasicClickCancel(){	
		
		yzFrameBasicCommonCancelClicked();
		
	}
	protected void yzFrameBasicClickEnd(){
		
		yzFrameBasicCommonTerm();
		
	}
	/*protected void MenuQuit(){
		
		yzframebasiccommonterm();
		
	}*/
	protected void yzFrameBasicCommonCancelClicked(){
		
		MyGUIUtility.ClearTextFieldOnContainerAll(this);
		//MyGUIUtility.ClearTextFieldOnContainer(pnlbutton);
		//this.cbxNotConfirm.setState(true);
		yzFrameBasicSetFirstItemWhenCancelClicked();
		
	}
	protected void yzFrameBasicClearItemOnCommonPanel(){
		
		
		
	}
	protected void yzFrameBasicSetFirstItemWhenCancelClicked(){
		
		cmpFirst.requestFocusInWindow();
		
	}
	protected void yzFrameBasicCommonTerm(){
		
		this.setVisible(false);
		System.exit(0);
		
	}
}
