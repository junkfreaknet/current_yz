/*
 * Created on 2005/02/21
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package mypackage.gui;
import java.awt.*;
/**
 * @author admnori
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class MyGUIUtility {

	public static void ClearTextFieldOnContainerAll(Container cnt){
		
		TextField txtf;
		//int inumofcmp=cnt.getComponentCount();
		Component[] cmp=cnt.getComponents();
		
		for(int iindex=0;iindex<cnt.getComponentCount();iindex++){
			if(cmp[iindex] instanceof Container){
				ClearTextFieldOnContainerAll((Container)cmp[iindex]);
			}
			if(cmp[iindex] instanceof TextField){
				txtf=(TextField)cmp[iindex];
				txtf.setText("");
			}
		}
		
	}
	public static void ClearTextFieldOnContainer(Container cnt){
		
		TextField txtf;
		//int inumofcmp=cnt.getComponentCount();
		Component[] cmp=cnt.getComponents();
		
		for(int iindex=0;iindex<cnt.getComponentCount();iindex++){
			if(cmp[iindex] instanceof TextField){
				txtf=(TextField)cmp[iindex];
				txtf.setText("");
			}
		}
		
	}	
}
