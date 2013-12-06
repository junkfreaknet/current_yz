/*
 * Created on 2005/01/31
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

public class MyTest{

	public MyTest(String title){
		
		Frame f=new Frame(title);
		f.setLayout(new GridBagLayout());
		//f.setLayout(new GridBagLayout());
		
		MakeButton(f,"A",0,0,1,2,0.0,0.0);
		MakeButton(f,"B",1,1,1,2,0.0,0.0);
		f.pack();
		f.setVisible(true);
		
	}
	static void MakeButton(Container cont,
			Object arg,
			int x,int y,
			int w,int h,
			double weightx,double weighty){
		
		GridBagLayout gbl=(GridBagLayout)cont.getLayout();
		GridBagConstraints c=new GridBagConstraints();
		Component comp;
		
		c.fill=GridBagConstraints.BOTH;
		c.gridx=x;
		c.gridy=y;
		c.gridwidth=w;
		c.gridheight=h;
		c.weightx=weightx;
		c.weighty=weighty;
		
		if(arg instanceof String){
			comp=new Button((String)arg);
		}else{
			comp=(Component)arg;
		}
		
		cont.add(comp);
		gbl.setConstraints(comp,c);
		
	}
	static public void main(String[] args) {
		MyTest mt=new MyTest("MyTest");
		
	}
}
