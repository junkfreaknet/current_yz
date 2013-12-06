/*
 * Created on 2004/08/17
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

public class MyFirstFileIO {

	public static void main(String[] args) {
		File ObjFile;
		FileReader ObjFileReader=null;
		try{
			ObjFile=new File(".","Person.txt");
			ObjFileReader=new FileReader(ObjFile);
			char[] CharBuffer=new char[256];
			int len;
			
			System.out.println("*** Program Start ***");
			
			while((len=ObjFileReader.read(CharBuffer))!=-1){
				System.out.println(CharBuffer);
			}
			
			ObjFileReader.close();
			System.out.println("*** Program has ended. ***");
		}
		catch(IOException e){
			System.out.println("File IO Error");
			System.out.println(e.getMessage());
			return;
		}
	}
		
}
