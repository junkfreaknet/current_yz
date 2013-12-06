/*
 * Created on 2005/04/21
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package yzpackage.file.encoding.converter;
import java.io.*;
import mypackage.file.utility.convert.encoding.*;
import mypackage.file.utility.*;
import mypackage.constant.*;
import yzpackage.constant.*;
import yzpackage.util.*;



/**
 * @author admnori
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CopyOfYZFileEncodingConverter extends Object{

	public static void ForPickingInDirectory(String strPathToFrom,String strPathToDist,String strPrefix,String strYear,String strMonth,String strDay,String strNo,String strConfirmOrNot,String strSourceEncoding,String strTargetEncoding){
		
		//String strPathFrom=strPathToFrom+"/"+strPrefix+strYear+strMonth+strDay+strNo+strConfirmOrNot;
		//String strPathDist=strPathToDist+"/"+strPrefix+strYear+strMonth+strDay+strNo+strConfirmOrNot;
		boolean bDebug;
		String strPathFrom=YZUtility.MakeDirectoryString(strPathToFrom,strPrefix,strYear,strMonth,strDay,strNo,strConfirmOrNot);
		String strPathDist=YZUtility.MakeDirectoryString(strPathToDist,strPrefix,strYear,strMonth,strDay,strNo,strConfirmOrNot);
		
		String strFileLists[];
		String strFileName;
		
		//StringBuffer sbFileName;
		
		int intSBLength;
		int iIndex;
		int iRecordLength;
		
		//StringBuffer sbFileName=new StringBuffer("");
		
		bDebug=true;
		bDebug=false;
		
		//for test begin
		if(bDebug){
			System.out.println("path from is "+strPathFrom);
			System.out.println("path to   is "+strPathDist);
		}
		//for test end
		
		File ff=new File(strPathFrom);
		
		if(MyFileUtility.IsExit(strPathDist)){
			MyFileUtility.Delete(strPathDist);
		}
		
		MyFileUtility.MkDir(strPathDist);
		
		strFileLists=ff.list();
		for(iIndex=0;iIndex<strFileLists.length;iIndex++){
			
			strFileName=strFileLists[iIndex];
			iRecordLength=0;
			
			//sbFileName.delete(0,sbFileName.length());
			//sbFileName.append(strFileLists[iIndex]);
			
			//System.out.println("file is "+strFileName);

			//if(strFileName.equals(YZConstant.FILENAMEMSUMSF)){
				//iRecordLength=Integer.valueOf(YZConstant.RECORDLENGTHOFMSUMSF).intValue();
			//}
			
			if(strFileName.matches(YZConstant.REGEXPMSUMSF)){
				iRecordLength=Integer.valueOf(YZConstant.RECORDLENGTHOFMSUMSF).intValue();				
			}
			if(strFileName.matches(YZConstant.REGEXPHHSEND)){
				iRecordLength=Integer.valueOf(YZConstant.RECORDLENGTHOFHHSEND).intValue();				
			}
			if(strFileName.matches(YZConstant.REGEXPMAFILE)){
				iRecordLength=Integer.valueOf(YZConstant.RECORDLENGTHOFMAFILE).intValue();				
			}
			if(strFileName.matches(YZConstant.REGEXPTTMP)){
				iRecordLength=Integer.valueOf(YZConstant.RECORDLENGTHOFTTMP).intValue();				
			}			
			//MyFileUtilityConvertEncoding.ConvertFilesDummy(strFileName,iRecordLength);
			//for test begin
			if(bDebug){
				System.out.println("file name is "+strFileName);
				System.out.println("record length is "+iRecordLength);
			}
			//for test end
			MyFileUtilityConvertEncoding.ConvertFileEncodingWithNewLine(strPathFrom,strFileName,MyConstant.ENCODINGEBCDIC,strPathDist,strFileName,MyConstant.ENCODINGDEFAULT,iRecordLength);
			
		}
	}
}
