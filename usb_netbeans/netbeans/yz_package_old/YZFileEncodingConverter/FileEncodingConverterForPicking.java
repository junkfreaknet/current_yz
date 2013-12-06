/*
 * Created on 2005/04/20
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
import mypackage.properties.*;
import yzpackage.gui.*;
import yzpackage.constant.*;
import yzpackage.file.encoding.converter.*;
import yzpackage.dialog.*;

public class FileEncodingConverterForPicking extends YZFileEncodingConverterForPicking{

	FileEncodingConverterForPicking(String strTitle,String strArgPrefix){
		
		super(strTitle,strArgPrefix);
		//strPathToFromFTP="d:/user/yz/doc/newdigi/data/fromftp";
		//strPathToTXT="d:/user/yz/doc/newdigi/data/txt";
		
		strPathToFromFTP=MyProperties.GetProperty(YZConstant.RESOURCEDIRECTORYFORSETTING+"/"+YZConstant.RESOURCEFILEFORSETTING,YZConstant.RESKEYFROMFTP);
		strPathToTXT=MyProperties.GetProperty(YZConstant.RESOURCEDIRECTORYFORSETTING+"/"+YZConstant.RESOURCEFILEFORSETTING,YZConstant.RESKEYTOTXT);
		
		//strPrefix=YZConstant.DATAPREFIXPICKING;
		
	}
	public void yzFrameBasicDoWhenCheckOK(){
		YZFileEncodingConverter.ForPickingInDirectory(strPathToFromFTP,strPathToTXT,strPrefix,strYear,strMonth,strDay,strNo,strConfirmOrNot,"ebcdic","default");
		YZDialog.OkOnly(YZConstant.RESKEYMSGEND);
	}
	public static void main(String[] args) {
		
		FileEncodingConverterForPicking mainframe=new FileEncodingConverterForPicking("YZ File Encoding Converter For Picking",YZConstant.DATAPREFIXPICKING);
		mainframe.setSize(400,400);
		mainframe.setVisible(true);
	}
}
