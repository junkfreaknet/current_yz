/*
 * Created on 2005/02/09
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
import mypackage.gui.*;
public class MyTesTesTes{

	public static void main(String[] args) {
		
		String strWidth;
		String strHeight;
		int intWidth;
		int intHeight;
		
		strWidth=args[0];
		strHeight=args[1];
		intWidth=Integer.valueOf(args[0]).intValue();
		intHeight=Integer.valueOf(args[1]).intValue();
		
		Frame f=new Frame("w="+args[0]+" h="+args[1]);
		f.setLayout(new GridBagLayout());
		
/*		MyConstraint.Constraint(f,new Label("Here MyTesTesTes come."),0,0,1,1);
		MyConstraint.Constraint(f,new Label("Here second line."),0,1,1,1);
		MyConstraint.Constraint(f,new Label("Here third line."),0,2,1,1);*/
		MyConstraint.Constraint(f,new Label("Year:"),0,3,intWidth,intHeight);
		TextField txtYYYY=new TextField("2005",4);
		MyConstraint.Constraint(f,txtYYYY,1,3,intWidth,intHeight);
		
		MyConstraint.Constraint(f,new Label("Month"),0,4,1,1);
		TextField txtMM=new TextField(2);
		MyConstraint.Constraint(f,txtMM,GridBagConstraints.RELATIVE,4,1,1);
		
		MyConstraint.Constraint(f,new Label("Day"),0,5,1,1);
		TextField txtDD=new TextField(2);
		MyConstraint.Constraint(f,txtDD,GridBagConstraints.RELATIVE,5,1,1);
		
		f.pack();
		f.setVisible(true);
		
	}
}
