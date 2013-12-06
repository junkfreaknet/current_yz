/*
 * Created on 2004/12/03
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
public class FrameTestMain extends Frame{

	public FrameTestMain(String title){
		super(title);
	}
	public boolean action(Event e,Object arg){
		System.out.print("An event is occured.\n");
		switch(e.id){
		case Event.WINDOW_DESTROY:
			System.out.print("Window is destroyed.\n");
			this.hide();
			this.dispose();
			return true;
        case Event.WINDOW_DEICONIFY:
        	System.out.print("Windows is deiconified.\n");
        	return true;
        case Event.WINDOW_EXPOSE:
        	System.out.print("Window is exposed.\n");
        	return true;
        case Event.WINDOW_ICONIFY:
        	System.out.print("Windos is iconified.\n");
        	return true;
        case Event.WINDOW_MOVED:
        	System.out.print("Window is moved.\n");
        	return true;
		default:
			System.out.print("Unknown event.\n");
			return false;
		}
	}
	public boolean handleEvent(Event e){
		System.out.print("An event is occured.\n");
		switch(e.id){
		case Event.WINDOW_DESTROY:
			System.out.print("Window is destroyed.\n");
			this.hide();
			this.dispose();
			return true;
        case Event.WINDOW_DEICONIFY:
        	System.out.print("Windows is deiconified.\n");
        	return true;
        case Event.WINDOW_EXPOSE:
        	System.out.print("Window is exposed.\n");
        	return true;
        case Event.WINDOW_ICONIFY:
        	System.out.print("Windos is iconified.\n");
        	return true;
        case Event.WINDOW_MOVED:
        	System.out.print("Window is moved.\n");
        	return true;
		default:
			System.out.print("Unknown event.\n");
			return false;
		}		
	}
	public static void main(String[] args) {
		Frame f=new FrameTestMain("InfoDialog Test");
		f.resize(100,100);
		f.show();
	}
}
