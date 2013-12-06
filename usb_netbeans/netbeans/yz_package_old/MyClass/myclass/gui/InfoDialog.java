/*
 * Created on 2004/12/03
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package myclass.gui;
import java.awt.*;
/**
 * @author admnori
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class InfoDialog extends Dialog{
	protected Button button;
	protected MultiLineLabel label;
	protected Frame frameparent;	
	public InfoDialog(Frame parent,String title,String message)
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
		frameparent=parent;
	}
	public boolean action(Event e,Object arg)
	{
		if(e.target==button){
			//this.hide();
			this.setVisible(false);
			this.dispose();
			//frameparent.hide();
			frameparent.setVisible(false);
			frameparent.dispose();
			//??? begin
			//System.exit(0);
			//??? end
			return true;
		}
		else return false;
	}
	public boolean gotFocus(Event e ,Object arg){
		button.requestFocus();
		return false;
	}

}
