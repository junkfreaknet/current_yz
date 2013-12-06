//import java.io.File;
//mod from w8
public class CheckFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//check no.1
		mycommons.routines.file.Filename fn=new mycommons.routines.file.Filename("gedit.xml");
		
		if(mycommons.routines.file.Generic.isExist(fn)){
			System.out.println("no.1 existing:"+fn.getName());
			System.out.println(fn.getAbsolutePath());
		}else{
			System.out.println("no.1 not exist:"+fn.getName());
		}
		
		//check no.2
		/***
		if(routines.file.general.isExist("gedit.xml")){
			System.out.println("no.2 existing:"+fn.GetName());
		}else{
			System.out.println("no.2 not exist:"+fn.GetName());
		}
		***/
		
	}

}
