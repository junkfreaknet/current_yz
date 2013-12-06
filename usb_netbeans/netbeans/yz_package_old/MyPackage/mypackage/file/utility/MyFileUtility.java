/*
 * Created on 2005/03/31
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package mypackage.file.utility;
import java.io.*;

/**
 * @author admnori
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class MyFileUtility {
	
	public static boolean IsExit(String strFile){
		
		boolean bReturn;
		File f=new File(strFile);
		bReturn=f.exists();
		
		return bReturn;
		
	}
	public static void Delete(String strFile){
		
		//boolean bIsValid;
		String strListNames[];
		int iIndex;
		String strAbsolutePath;
		
		File f=new File(strFile);
		
		//bIsValid=f.isDirectory();
		//System.out.println("isDirectory is "+bIsValid);
		if(f.isDirectory()){
			strListNames=f.list();
			if(strListNames==null){
				f.delete();
			}else{
				for(iIndex=0;iIndex<strListNames.length;iIndex++){
					//System.out.println(strListNames[iIndex]);
					File fList=new File(strFile+"/"+strListNames[iIndex]);
					strAbsolutePath=fList.getAbsolutePath();
					//System.out.println("absolute path of "+strListNames[iIndex]+" is "+strAbsolutePath);
					if(fList.isDirectory()){
						Delete(strAbsolutePath);
					}
					fList.delete();
				}
				//System.out.println("deleting "+f.getAbsolutePath());
				f.delete();
				
			}
		}else{
			f.delete();
		}
		
	}
	public static void MkDir(String strFile){
		
		boolean bIsValid;
		
		File f=new File(strFile);
		
		bIsValid=f.mkdir();
		
	}
}
