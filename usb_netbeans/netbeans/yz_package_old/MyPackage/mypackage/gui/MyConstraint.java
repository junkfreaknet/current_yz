/*
 * Created on 2005/01/29
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
public class MyConstraint extends Object{
	//Constrain object constructor basic
	public static void Constraint(Container container,Component component,
			int grid_x,int grid_y,
			int grid_width,int grid_height,
			int fill,int anchor,
			double weight_x,double weight_y,
			int top,int left,
			int bottom,int right)
	{
		//Set Constraint value
		ConstraintCommon(container,component,grid_x,grid_y,grid_width,grid_height,fill,anchor,weight_x,weight_y,top,left,bottom,right);
	}
	//Constraint object constructor #2
	public static void Constraint(Container container,
			Component component,
			int grid_x,int grid_y,
			int grid_width,int grid_height)
	{
		ConstraintCommon(container,component,
				grid_x,grid_y,
				grid_width,grid_height,
				GridBagConstraints.NONE,GridBagConstraints.NORTHWEST,
				0.0,0.0,
				0,0,
				0,0);		
	}
	//Constraint object constructor #3
	public static void Constraint(Container container,Component component,
			int grid_x,int grid_y,
			int grid_width,int grid_height,
			int top,int left,int bottom,int right)
	{
		ConstraintCommon(container,component,
			grid_x,grid_y,
			grid_width,grid_height,
			GridBagConstraints.NONE,GridBagConstraints.NORTHWEST,
			0.0,0.0,
			top,left,
			bottom,right);
	}
	
	//Constraint body
	static void ConstraintCommon(Container container,Component component,
			int grid_x,int grid_y,
			int grid_width,int grid_height,
			int fill,int anchor,
			double weight_x,double weight_y,
			int top,int left,
			int bottom,int right)
	{
		//Set Constraint value
		GridBagLayout gbl=(GridBagLayout)container.getLayout();
		GridBagConstraints c =new GridBagConstraints();
		
		c.gridx=grid_x;c.gridy=grid_y;
		c.gridwidth=grid_width;c.gridheight=grid_height;
		c.fill=fill;c.anchor=anchor;
		c.weightx=weight_x;c.weighty=weight_y;
		//Set Constraint value end
		
		if(top+bottom+left+right>0)
			c.insets=new Insets(top,left,bottom,right);
			//c.insets=container.getInsets();
		//set  components Constraint values ---> container layout object(GridBagLayout object)
		//container.add(component);
		//((GridBagLayout)container.getLayout()).setConstraints(component,c);
		container.add(component);
		gbl.setConstraints(component,c);		
		//add component to container.
		//container.add(component);
	}
}
