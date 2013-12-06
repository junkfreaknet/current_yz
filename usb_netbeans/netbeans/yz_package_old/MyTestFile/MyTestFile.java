/*
 * Created on 2005/03/28
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
import java.io.*;

public class MyTestFile {

	public static void main(String[] args) {
		
		int iIndex;
		String strFiles[];
		
		File f=new File("d:/");
		strFiles=f.list();
		for(iIndex=0;iIndex<strFiles.length;iIndex++){
			System.out.println("list of contents is "+strFiles[iIndex]);
		}
	}
}
