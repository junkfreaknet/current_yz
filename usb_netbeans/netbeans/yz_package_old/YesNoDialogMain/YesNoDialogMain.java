/*
 * Created on 2004/12/06
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
import MyCustomComponent.*;
import java.awt.*;
public class YesNoDialogMain extends YesNoDialog{
	/*TextComponent status;*/
	/*public YesNoDialogMain(Frame parent,TextComponent status){*/
	public YesNoDialogMain(Frame parent){
		super(parent,"Really Quit?","Really Quit?","Yes","No",null);
		/*this.status=status;*/
	}
	public void yes(){System.exit(0);}
	public void no(){}
	/*public void no(){if(status!=null)status.setText("Quit Cancelled.");}*/
	
	public static void main(String[] args) {
		Frame f=new Frame("Info Dialog Test With Decision Button");
		f.resize(100,100);
		f.show();
		YesNoDialogMain d=new YesNoDialogMain(f);
		/*YesNoDialogMain d=new YesNoDialogMain(f,"Abut AWT Demo",
				"This demo was written by David Flanagan & Noriyuki Takarabe\n" +
				"Copyright(c)2004 O'Reilly & Associates");*/
		d.show();
	}
}
