/*
 * Created on 2004/12/03
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
public class MainFrame extends Frame{

	public MainFrame(String title){
		super(title);
	}
	public boolean handleEvent(Event e){
		/*System.out.print("An event is occured.\n");*/
		switch(e.id){
		case Event.WINDOW_DESTROY:
			System.out.print("Window is destroyed.\n");
			this.hide();
			this.dispose();
			return true;
		default:
			/*System.out.print("Unknown event.\n");*/
			return false;
		}
	}
}
