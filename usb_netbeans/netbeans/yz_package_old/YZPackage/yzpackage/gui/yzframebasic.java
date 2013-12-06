/*
 * Created on 2005/01/25
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package yzpackage.gui;

import java.awt.*;
import mypackage.gui.*;
import mypackage.constant.*;
import yzpackage.i18n.*;
import yzpackage.constant.*;

/**
 * @author admnori
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
/***
 * 
 * This class is basic frame for YZ system.
 * It has a text box to input shipping date.
 * Shipping date is basic element of YZ system.
 * It is key of every data processing.
 * 
 ***/
public class yzframebasic extends Frame{
	
	MenuBar mnbMenubar;
	Menu mnFile,mnHelp;
	MenuItem mniOpen;
	MenuItem mniQuit;
	MenuItem mniAbout;
	
	Button btnOk,btnCancel,btnEnd;
	
	public TextField txtfShippingDateYYYY;
	public TextField txtfShippingDateMM;
	public TextField txtfShippingDateDD;
	
	Panel pnlcommon;
	Panel pnlbutton;
	
	//Componet title
	String strMnFile;
	String strMnHelp;
	String strMniOpen;
	String strMniQuit;
	String strMniAbout;

	String strBtnOK;
	String strBtnCancel;
	String strBtnEnd;
	
	//YZ Component title
	String strLblYear;
	String strLblMonth;
	String strLblDay;
	

	
	static final int GRIDYOFYEAR=0;
	static final int GRIDYOFMONTH=1;
	static final int GRIDYOFDAY=2;
	
	//constructor #1
	public yzframebasic(String strTitle){
	
		super(strTitle);
		this.setLayout(new GridBagLayout());
		yzFrameCreateContainerCommon();
		
	}
	//constructor #2
	public yzframebasic(){
		
		super("Yamazaki Bakerly Main menu");
		this.setLayout(new GridBagLayout());
		yzFrameCreateContainerCommon();
		
	}
	//constructor body.
	protected void yzFrameCreateContainerCommon(){
		
		mnbMenubar=new MenuBar();
		this.setMenuBar(mnbMenubar);
		//set items on frame.
		yzFrameBasicSetComponentTitle();
		yzFrameBasicCreateMenu();
		yzFrameBasicCreateYMDTextfield();
		yzFrameBasicCreateCommonButton();
		yzFrameBasicSetCommonLayout();
		//yzFrameBasicSetFirstItem();
		//System.out.println(strMnFile);

	}
	//
	//Component title setter.
	//Set menue item title ,button title,label from resource file
	//
	protected void yzFrameBasicSetComponentTitle(){

			strMnFile=YZI18NUtility.getString(MyConstant.I18NStringResource,MyConstant.RESKEYFILE);
			strMnHelp=YZI18NUtility.getString(MyConstant.I18NStringResource,MyConstant.RESKEYHELP);
			strMniOpen=YZI18NUtility.getString(MyConstant.I18NStringResource,MyConstant.RESKEYOPEN);
			strMniQuit=YZI18NUtility.getString(MyConstant.I18NStringResource,MyConstant.RESKEYQUIT);
			strMniAbout=YZI18NUtility.getString(MyConstant.I18NStringResource,MyConstant.RESKEYABOUT);

			strBtnOK=YZI18NUtility.getString(MyConstant.I18NStringResource,MyConstant.RESKEYOK);
			strBtnCancel=YZI18NUtility.getString(MyConstant.I18NStringResource,MyConstant.RESKEYCANCEL);
			strBtnEnd=YZI18NUtility.getString(MyConstant.I18NStringResource,MyConstant.RESKEYEND);
	
			strLblYear=YZI18NUtility.getString(YZConstant.I18NStringResource,YZConstant.RESKEYSHIPPINGDATEYEAR);
			strLblMonth=YZI18NUtility.getString(YZConstant.I18NStringResource,YZConstant.RESKEYSHIPPINGDATEMONTH);
			strLblDay=YZI18NUtility.getString(YZConstant.I18NStringResource,YZConstant.RESKEYSHIPPINGDATEDAY);
			
	}
	//
	//Menu setter. 
	//Sub classes of yzframebasci can change this method
	//by overridding it.
	//

	protected void yzFrameBasicCreateMenu(){
		
		mnFile=new Menu(strMnFile);
		mniOpen=new MenuItem(strMniOpen);
		mnFile.add(mniOpen);
		mniQuit=new MenuItem(strMniQuit);
		mnFile.add(mniQuit);
		mnbMenubar.add(mnFile);
		
		mnHelp=new Menu(strMnHelp);
		mniAbout=new MenuItem(strMniAbout);
		mnHelp.add(mniAbout);
		mnbMenubar.add(mnHelp);
		mnbMenubar.setHelpMenu(mnHelp);
		
	}
	//Text field setter
	//Usage is same as "Menu setter"
	protected void yzFrameBasicCreateYMDTextfield(){
		
		txtfShippingDateYYYY=new TextField(4);
		txtfShippingDateMM=new TextField(2);
		txtfShippingDateDD=new TextField(2);
		
	}
	//
	//Button setter.
	//Usage is same as above.
	//
	protected void yzFrameBasicCreateCommonButton(){
		
		btnOk=new Button(strBtnOK);
		btnCancel=new Button(strBtnCancel);
		btnEnd=new Button(strBtnEnd);
		
	}
	//
	//Layout setter.
	//Usage:
	//
	protected void yzFrameBasicSetCommonLayout(){
		
		yzFrameBasicSetYMDLayout();
		yzFrameBasicSetCommonButtonLayout();
		yzFrameBasicSetPanelLayout();
		
	}
	protected void yzFrameBasicSetYMDLayout(){

		//layout shipping date ---> panel
		pnlcommon=new Panel();
		pnlcommon.setLayout(new GridBagLayout());
		
		MyConstraint.Constraint(pnlcommon,new Label(strLblYear),0,GRIDYOFYEAR,1,1);
		MyConstraint.Constraint(pnlcommon,txtfShippingDateYYYY,1,GRIDYOFYEAR,1,1);
		
		MyConstraint.Constraint(pnlcommon,new Label(strLblMonth),0,GRIDYOFMONTH,1,1);
		MyConstraint.Constraint(pnlcommon,txtfShippingDateMM,1,GRIDYOFMONTH,1,1);
		
		MyConstraint.Constraint(pnlcommon,new Label(strLblDay),0,GRIDYOFDAY,1,1);
		MyConstraint.Constraint(pnlcommon,txtfShippingDateDD,1,GRIDYOFDAY,1,1);
		
	}
	protected void yzFrameBasicSetCommonButtonLayout(){
		
		//layout button ---> panel
		pnlbutton=new Panel();
		pnlbutton.setLayout(new GridBagLayout());

		//*** Original start.
		/*MyConstraint.Constraint(pnlbutton,btnOk,0,0,1,1,GridBagConstraints.NONE,
				GridBagConstraints.CENTER,0.3,0.0,0,0,0,0);
		MyConstraint.Constraint(pnlbutton,btnCancel,3,0,1,1,GridBagConstraints.NONE,
				GridBagConstraints.CENTER,0.3,0.0,0,0,0,0);*/
		//*** Original end.
		//MyConstraint.Constraint(pnlbutton,btnOk,0,0,2,1);
		//MyConstraint.Constraint(pnlbutton,btnCancel,3,0,1,1);
		MyConstraint.Constraint(pnlbutton,btnOk,0,0,1,1,GridBagConstraints.NONE,
				GridBagConstraints.CENTER,1.0,0.0,0,0,0,0);
		MyConstraint.Constraint(pnlbutton,btnCancel,1,0,1,1,GridBagConstraints.NONE,
				GridBagConstraints.CENTER,1.0,0.0,0,0,0,0);
		MyConstraint.Constraint(pnlbutton,btnEnd,2,0,1,1,GridBagConstraints.NONE,
				GridBagConstraints.CENTER,1.0,0.0,0,0,0,0);
		
	}
	protected void yzFrameBasicSetPanelLayout(){
		
		//layout panel ---> frame
		//this.setLayout(new GridBagLayout());
		MyConstraint.Constraint(this,pnlcommon,0,0,1,1);
		//MyConstraint.Constraint(this,pnlbutton,0,1,6,1);
		MyConstraint.Constraint(this,pnlbutton,0,1,1,1,GridBagConstraints.BOTH,
				GridBagConstraints.CENTER,0.0,0.0,0,0,0,0);
		
	}

}
