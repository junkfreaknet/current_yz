/*
 * Created on 2004/12/02
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
import MyCustomComponent.*;
public class InfoDialog2 extends Dialog{
	protected Button button;
	protected MultiLineLabel label;
	protected Frame mainframe;	
	public InfoDialog2(Frame parent,String title,String message)
	{
		super(parent,title,false);
		this.setLayout(new BorderLayout(15,15));
		label=new MultiLineLabel(message,20,20);
		this.add("Center",label);
		button=new Button("Okay");
		Panel p=new Panel();
		p.setLayout(new FlowLayout(FlowLayout.CENTER,15,15));
		p.add(button);
		this.add("South",p);
		this.pack();
		mainframe=parent;
	}
	public boolean action(Event e,Object arg)
	{
		if(e.target==button){
			this.hide();
			this.dispose();
			return true;
		}
		else return false;
	}
	public boolean gotFocus(Event e ,Object arg){
		button.requestFocus();
		return false;
	}
	public static void main(String[] args) {
		Frame f=new Frame("InfoDialog Test");
		f.resize(100,100);
		f.show();
		InfoDialog2 d=new InfoDialog2(f,"About AWT Demo",
				     "This demo was written by David Flanagan and Noriyuki Takarabe\n"+
					 "Copyright(c) 1996 O'Reilly & Associates");
		d.show();		
	}
}
