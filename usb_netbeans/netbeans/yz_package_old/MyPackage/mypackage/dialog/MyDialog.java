/*
 * Created on 2005/03/21
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package mypackage.dialog;
import myclass.gui.*;
import java.awt.*;


/**
 * @author admnori
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class MyDialog extends Object{
	public static void ErrorDialog(String strFrameTitle,String strDialogTitle,String strDialogMessage){

		Frame f=new Frame(strFrameTitle);
		
		f.setSize(300,300);
		InfoDialog d=new InfoDialog(f,strDialogTitle,strDialogMessage);
		d.setVisible(true);
	}
}
