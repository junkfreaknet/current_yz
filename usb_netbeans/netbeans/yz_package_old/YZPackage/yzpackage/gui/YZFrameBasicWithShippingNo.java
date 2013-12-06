/*
 * Created on 2005/02/15
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package yzpackage.gui;
import java.awt.*;
import mypackage.gui.*;
import yzpackage.i18n.*;
import yzpackage.constant.*;

//import mypackage.MyConstraint;


/**
 * @author admnori
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class YZFrameBasicWithShippingNo extends yzframebasic{
	
	//shipping number field
	public TextField txtfShippingNo;
	String strLblShippingNo;
	
	//confirm or not check box group and elements
	public CheckboxGroup cbxg;
	public Checkbox cbxNotConfirm;
	String strLblNotConfirm;
	public Checkbox cbxConfirm;
	String strLblConfirm;
	
	static final int GRIDYOFSHIPPINGNO=3;
	static final int GRIDYOFCHECKBOXNOTCONFIRM=4;
	static final int GRIDYOFCHECKBOXCONFIRM=5;
	
	//Panel pnlshippingno;

	//public constructor #1
	public YZFrameBasicWithShippingNo(){
		
		super();
		yzFrameBasicWithShippingNoCreateContainerCommon();

	}
	//public constructor #2
	public YZFrameBasicWithShippingNo(String strtitle){
		
		super(strtitle);
		yzFrameBasicWithShippingNoCreateContainerCommon();
		
	}
	//constructor body.
	/*protected void yzFrameCreateContainerCommon(){
		
		mnbMenubar=new MenuBar();
		this.setMenuBar(mnbMenubar);
		//set items on frame.
		yzFrameBasicCreateMenu();
		yzFrameBasicCreateYMDTextfield();
		yzFrameBasicCreateCommonButton();
		yzFrameBasicWithShippingNoCreateTextField();
		yzFrameBasicSetCommonLayout();
		yzFrameBasicSetFirstItem();

	}*/
	protected void yzFrameBasicWithShippingNoCreateContainerCommon(){
		
		yzFrameBasicWithShippingNoCreateTextField();
		yzFrameBasicWithShippingNoCreateCheckBoxGroup();
		yzFrameBasicSetShippingNoLayout();
		yzFrameBasicSetCheckBoxGroupLayout();
		
	}
	protected void yzFrameBasicWithShippingNoCreateTextField(){
		
		strLblShippingNo=YZI18NUtility.getString(YZConstant.I18NStringResource,YZConstant.RESKEYSHIPPINGNO);
		txtfShippingNo=new TextField(2);
		
	}
	protected void yzFrameBasicWithShippingNoCreateCheckBoxGroup(){
	
		strLblNotConfirm=YZI18NUtility.getString(YZConstant.I18NStringResource,YZConstant.RESKEYNOTCONFIRM);
		strLblConfirm=YZI18NUtility.getString(YZConstant.I18NStringResource,YZConstant.RESKEYCONFIRM);
		
		cbxg=new CheckboxGroup();
		cbxNotConfirm=new Checkbox(strLblNotConfirm,true,cbxg);
		cbxConfirm=new Checkbox(strLblConfirm,false,cbxg);
		
	}
	/*protected void yzFrameBasicSetCommonLayout(){
		
		yzFrameBasicSetYMDLayout();
		yzFrameBasicSetShippingNoLayout();
		yzFrameBasicSetCommonButtonLayout();
		yzFrameBasicSetPanelLayout();		
	}*/
	protected void yzFrameBasicSetShippingNoLayout(){

		//***layout shipping number ---> panel
		//***Layout shipping number on same panel
		//***which includes shipping date
		//***There no necessity setting layout manager.
		//***
		//pnlcommon=new Panel();
		//pnlcommon.setLayout(new GridBagLayout());
		
		MyConstraint.Constraint(pnlcommon,new Label(strLblShippingNo),0,GRIDYOFSHIPPINGNO,1,1);
		MyConstraint.Constraint(pnlcommon,txtfShippingNo,1,GRIDYOFSHIPPINGNO,1,1);
	}
	protected void yzFrameBasicSetCheckBoxGroupLayout(){
		
		MyConstraint.Constraint(pnlcommon,cbxNotConfirm,1,GRIDYOFCHECKBOXNOTCONFIRM,1,1);
		MyConstraint.Constraint(pnlcommon,cbxConfirm,1,GRIDYOFCHECKBOXCONFIRM,1,1);
		
	}
	/*public void yzFrameBasicSetPanelLayout(){
		
		//layout panel ---> frame
		this.setLayout(new GridBagLayout());
		MyConstraint.Constraint(this,pnlcommon,0,0,1,1);
		//MyConstraint.Constraint(this,pnlshippingno,0,1,1,1);
		MyConstraint.Constraint(this,pnlbutton,0,2,1,1);
		
	}*/
}
