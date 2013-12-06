import java.io.FileInputStream;


public class ReTryPrintFromFileOneTime implements java.awt.print.Printable{

	boolean isfirst=true;
	
	public int print(java.awt.Graphics g,java.awt.print.PageFormat pf,int page) throws java.awt.print.PrinterException{
		
		final String INFILE=".\\inFiles/in.txt";
		java.io.FileInputStream fis=null;
		java.io.InputStreamReader isr=null;
		
		int oneIn=0;
		int buffSize=0;
		int statIn=0;
		
		String encoding;
		
		//get count of characters
		try{
			
			fis=new java.io.FileInputStream(INFILE);
			while(oneIn!=-1){
				try{
					
					oneIn=fis.read();
					buffSize=buffSize+1;
					
				}catch(java.io.IOException e){
					System.out.println(e.toString());
					System.exit(1);
				}
			}			
		}catch(java.io.FileNotFoundException e){
			System.out.println(e.toString());
			System.exit(1);
		}
		
		//print file data
		if(page<1){
		//====================
			try{
			encoding=System.getProperty("file.encoding");
			char[] charBuff_s=new char[buffSize];
			
			fis=new java.io.FileInputStream(INFILE);
			try{
				isr=new java.io.InputStreamReader(fis, encoding);
				try{
					statIn=isr.read(charBuff_s, 0, buffSize);
					if(statIn==-1){
						System.out.println("no data to print.");
						System.exit(1);
					}
					java.awt.FontMetrics fm=g.getFontMetrics();
					
					int posX=(int)pf.getImageableX();
					int posY=(int)pf.getImageableY()+fm.getHeight();
					g.drawChars(charBuff_s, 0, buffSize, posX, posY);
					fis.close();
					return java.awt.print.Printable.PAGE_EXISTS;
					
				}catch(java.io.IOException e){
					System.out.println(e.toString());
					System.exit(1);
				}
			}catch(java.io.UnsupportedEncodingException e){
				System.out.println(e.toString());
				System.exit(1);
			}
		}catch(java.io.FileNotFoundException e){
			System.out.println(e.toString());
			System.exit(1);
		}
		//====================
		}else{
			return java.awt.print.Printable.NO_SUCH_PAGE;
		}
		return java.awt.print.Printable.NO_SUCH_PAGE;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String PGNAME="ReTryPrintFromFileOneTime";
		
		System.out.println("start of "+PGNAME);
		java.awt.print.PrinterJob pj=java.awt.print.PrinterJob.getPrinterJob();
		pj.setJobName(PGNAME);
		pj.setPrintable(new ReTryPrintFromFileOneTime());
		try{
			pj.print();
		}catch(java.awt.print.PrinterException e){
			System.out.println(e.toString());
			System.exit(1);
		}
		System.out.println("end of "+PGNAME);
	}

}
