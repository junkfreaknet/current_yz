/*
 * Created on 2004/12/03
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
/*import java.awt.Frame;*/

import MyCustomComponent.*;
import java.awt.*;
public class InfoDialogMain {

	public static void main(String[] args) {
		//new begin
		//Dimension dm=new Dimension(300,300);
		//new end
		Frame f=new Frame("InfoDialog Test");
		//f.resize(300,300);
		f.setSize(300,300);
		//f.show();
		//f.setVisible(true);
		InfoDialog d=new InfoDialog(f,"About AWT Demo",
				     "This demo was written by David Flanagan and Noriyuki Takarabe\n"+
					 "Copyright(c) 1996 O'Reilly & Associates");
		//d.show();
		d.setVisible(true);
		/*f.hide();
		f.dispose();*/
		//f.setVisible(true);
		//f.dispose();
	}
}
