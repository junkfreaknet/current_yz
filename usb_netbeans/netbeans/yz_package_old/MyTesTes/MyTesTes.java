/*
 * Created on 2005/02/07
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
public class MyTesTes extends Frame{
public MyTesTes(){
	
	//Create frame.
	super("Mytestes");
	//this.setLayout(new GridBagLayout());
	//Create panel.
	Panel pnlupper=new Panel();
	pnlupper.setLayout(new GridBagLayout());
	GridBagLayout gbl=(GridBagLayout)pnlupper.getLayout();
	
	//Create Date form. 
	//Label & text field for year.
	Label lblYY=new Label("Year");
	pnlupper.add(lblYY);
	GridBagConstraints cYY=new GridBagConstraints();
	cYY.anchor=GridBagConstraints.NORTHWEST;
	gbl.setConstraints(lblYY,cYY);
	
	TextField txtfYYYY=new TextField("",4);
	pnlupper.add(txtfYYYY);
	gbl.setConstraints(txtfYYYY,cYY);
	
	//Label & text field for month.	
	Label lblMM=new Label("Month");
	pnlupper.add(lblMM);
	GridBagConstraints cMM=new GridBagConstraints();
	cMM.gridy=1;
	gbl.setConstraints(lblMM,cMM);

	TextField txtfMM=new TextField("",2);
	pnlupper.add(txtfMM);
	gbl.setConstraints(txtfMM,cMM);
	
	//Label & text field for day.
	Label lblDD=new Label("Day");	
	pnlupper.add(lblDD);
	GridBagConstraints cDD=new GridBagConstraints();
	cDD.gridy=2;
	gbl.setConstraints(lblDD,cDD);
	
	TextField txtfDD=new TextField("",2);
	pnlupper.add(txtfDD);
	gbl.setConstraints(txtfDD,cDD);
	
	this.add(pnlupper);
	//GridBagConstraints gbc=new GridBagConstraints();
	
	
	this.pack();
	this.setVisible(true);
}
	public static void main(String[] args) {
		MyTesTes mine=new MyTesTes();
	}
}
