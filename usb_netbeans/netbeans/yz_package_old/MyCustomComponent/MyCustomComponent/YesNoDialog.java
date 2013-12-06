/*
 * Created on 2004/12/06
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package MyCustomComponent;
import java.awt.*;
/**
 * @author admnori
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class YesNoDialog extends Dialog{

public static final int NO=0;
public static final int YES=1;
public static final int CANCEL=-1;
protected Button yes=null,no=null,cancel=null;
protected MultiLineLabel label;

public YesNoDialog(Frame parent,String title,String message,
		String yes_label,String no_label,String cancel_label){
	super(parent,title,true);
	this.setLayout(new BorderLayout(15,15));
	label=new MultiLineLabel(message,20,20);
	this.add("Center",label);
	Panel p=new Panel();
	p.setLayout(new FlowLayout(FlowLayout.CENTER,15,15));
	if(yes_label!=null) p.add(yes=new Button(yes_label));
	if(no_label!=null) p.add(no=new Button(no_label));
	if(cancel_label!=null) p.add(no=new Button(cancel_label));
	this.add("South",p);
	this.pack();
}
public boolean action(Event e,Object arg){
	if(e.target instanceof Button){
		this.hide();
		this.dispose();
		if(e.target==yes) answer(YES);
		else if(e.target==no) answer(NO);
		else answer(CANCEL);
		return true;
	}
	else return false;
}
protected void answer(int answer){
	switch(answer){
		case YES:yes();break;
		case NO:no();break;
		case CANCEL:cancel();break;
	}
}
protected void yes(){}
protected void no(){}
protected void cancel(){}
}
