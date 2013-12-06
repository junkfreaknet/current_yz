import java.io.FileInputStream;


public class ReTryPrintFromFileAnyTime implements java.awt.print.Printable{

	boolean isfirst=true;
	String encoding;
	//save---input stream reader
	java.io.InputStreamReader isr;
	boolean isEndOfFile=false;

	int posX=0;
	int posY=0;
	//*****
	//***** print method
	//*****
	public int print(java.awt.Graphics g,java.awt.print.PageFormat pf,int page) throws java.awt.print.PrinterException{
		
		final String INFILE=".\\inFiles/in.txt";
		java.io.FileInputStream fis=null;
		//java.io.InputStreamReader isr=null;
		
		//int oneIn=0;
		//int buffSize=0;
		//int statIn=0;
		int inBuff=0;
		
		int charWidth=getAverageWidthCharacters(g);
		int pageWidth=(int)pf.getWidth();
		int pageHeight=(int)pf.getHeight();
		int maxX=(int)pf.getImageableX()+(int)pf.getWidth();
		int maxY=(int)pf.getImageableY()+(int)pf.getHeight();
		
		final int firstPAGE=0;
		final int end_OF_FILE=-1;

		
		//get count of characters
		
		//print file data
		

		//encoding=System.getProperty("file.encoding");
		
		if(isEndOfFile){
			return java.awt.print.Printable.NO_SUCH_PAGE;
		}
		if(page==firstPAGE){
			//initialing for document 
			isr=initInputStreamReader(INFILE,System.getProperty("file.encoding"));
			/***
			try{
				fis=new java.io.FileInputStream(INFILE);
				try{
					isr=new java.io.InputStreamReader(fis, System.getProperty("file.encoding"));
				}catch(java.io.UnsupportedEncodingException e){
					System.out.println(e.toString());
					System.exit(1);
				}
			}catch(java.io.FileNotFoundException e){
				System.out.println(e.toString());
				System.exit(1);
			}
			***/
			posX=initPosX(pf);
			posY=initPosY(g,pf);
			System.out.println("encoding is "+isr.getEncoding());
			System.out.println("separator is "+ System.getProperty("line.separator"));
		}
		while(true){
			try{
				while(true){
					inBuff=isr.read();
					//if EOF and line of document is empty.terminate print().
					//BUT,BUT IF THE LAST LINE OF DOCMENT.***FLUSH THE LAST LINE.
					if(inBuff==end_OF_FILE){
						if(posX==initPosX(pf)){
							return java.awt.print.Printable.NO_SUCH_PAGE;
						}else{
							isEndOfFile=true;
							g.drawString(String.valueOf(inBuff), posX,posY);
							return java.awt.print.Printable.PAGE_EXISTS;
						}
					}
					//new line?
					 //if(string==System.getProperty("line.separator")){
					 //}
					java.lang.Integer intBuff=new java.lang.Integer(inBuff);
					java.lang.Byte byteBuff=intBuff.byteValue();
					byte[] byteBuff_s=new byte[1];
					byteBuff_s[0]=byteBuff;
					String stringBuff=new java.lang.String(byteBuff_s, java.nio.charset.Charset.defaultCharset());
					
					g.drawString(stringBuff, posX, posY);
					System.out.println(stringBuff);
					//next x position
					posX=nextPosX(posX,charWidth);
					if(posX>=maxX){
						posX=initPosX(pf);
						posY=nextPosY(g,pf,posY);
						return java.awt.print.Printable.PAGE_EXISTS;
					}
					//return java.awt.print.Printable.PAGE_EXISTS;
				}

			}catch(java.io.IOException e){
				System.out.println(e.toString());
				System.exit(1);
			}			
		}
		//return java.awt.print.Printable.NO_SUCH_PAGE;
	}
	//*****
	//***** private methods called from print()
	//*****
	//initialize input stream reader
	private java.io.InputStreamReader initInputStreamReader(String fileName,String coding){
		
		java.io.InputStreamReader rv=null;
		java.io.FileInputStream fis=null;
		
		try{
			fis=new java.io.FileInputStream(fileName);
			try{
				rv=new java.io.InputStreamReader(fis, coding);
			}catch(java.io.UnsupportedEncodingException e){
				System.out.println(e.toString());
				System.exit(1);
			}
		}catch(java.io.FileNotFoundException e){
			System.out.println(e.toString());
			System.exit(1);
		}		
		return rv;
	}
	private int initPosX(java.awt.print.PageFormat pf){
		return (int)pf.getImageableX();
	}
	private int nextPosX(int x,int width){
		return x=x+width;
	}
	private int initPosY(java.awt.Graphics g,java.awt.print.PageFormat pf){
		return (int)pf.getImageableY()+g.getFontMetrics().getHeight();
	}
	private int nextPosY(java.awt.Graphics g,java.awt.print.PageFormat pf,int y){
		
		return y=y+(int)pf.getImageableY()+g.getFontMetrics().getHeight();
	}
	private int getAverageWidthCharacters(java.awt.Graphics g){
		
		return g.getFont().getSize();
		/***
		int len;
		int sumWidth=0;
		
		len=g.getFontMetrics().getWidths().length;
		int[] width_s=new int[len];
		
		width_s=g.getFontMetrics().getWidths();
		for(int i=0;i<len;i++){
			sumWidth=sumWidth+width_s[i];
		}
		return (int)sumWidth/len;
		***/
	}
	//*****
	//***** main 
	//*****
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String PGNAME="ReTryPrintFromFileAnyTime";
		
		System.out.println("start of "+PGNAME);
		java.awt.print.PrinterJob pj=java.awt.print.PrinterJob.getPrinterJob();
		pj.setJobName(PGNAME);
		pj.setPrintable(new ReTryPrintFromFileAnyTime());
		try{
			pj.print();
		}catch(java.awt.print.PrinterException e){
			System.out.println(e.toString());
			System.exit(1);
		}
		System.out.println("end of "+PGNAME);
	}

}
