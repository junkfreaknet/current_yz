/*
 * Created on 2004/12/12
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
import java.awt.*;
public class MyOriginalGUI {

	public static void main(String[] args) {
		Frame f;
		Panel p;
		Button b001;
		Button b002;
		Event e;
		
		f=new Frame("My Original GUI");
		f.resize(300,300);
		/*f.setLayout(new BorderLayout(15,15));*/
		f.setLayout(new FlowLayout(FlowLayout.CENTER,15,230));
		/*p=new Panel();
		p.setLayout(new FlowLayout(FlowLayout.CENTER,15,15));*/
		b001=new Button("  OK  ");
		b002=new Button("Cancel");
		f.add("South",b001);
		f.add("South",b002);
		f.show();
		while(true){
			e=new Event(b001);
			action(e);
		}
	}
	static void action(Event e){
	}
}
