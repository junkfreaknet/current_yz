//import java.io.F		final String INFILE=".\\inFiles/in.txt";


public class tryInfilePrintOneTimeEncoding implements java.awt.print.Printable{

	int cntCall=0;
	
	public int print(java.awt.Graphics g,java.awt.print.PageFormat pf,int page) throws java.awt.print.PrinterException{

		final String INFILE=".\\inFiles/in.txt";

		java.io.FileInputStream fis=null;
		java.io.InputStreamReader isr=null;
		
		int cntIn;
		char[] charBuff=new char[1000];
		
		int size=g.getFont().getSize();
		int posX=(int)pf.getImageableX()+size;
		int posY=(int)pf.getImageableY()+size;

		String encoding;
		
		//get num of charachers in file
		System.out.println("page is "+String.valueOf(page)+" call cnt is "+String.valueOf(cntCall)+" encoding is "+System.getProperty("file.encoding"));
		encoding=System.getProperty("file.encoding");
		posX=(int)pf.getImageableX()+g.getFont().getSize();
		posY=(int)pf.getImageableY()+g.getFont().getSize();
		
		//if(cntCall==0){
		if(page<2){
			cntCall=1;
			try{
				fis=new java.io.FileInputStream(INFILE);
				try{
					isr=new java.io.InputStreamReader(fis, encoding);
					try{
						cntIn=isr.read(charBuff);
						g.drawChars(charBuff, 0, charBuff.length, posX, posY);
						//g.drawString(charBuff.toString(), posX+100, posY+100);
						//g.drawString("ABC", posX, posY);
						System.out.println(charBuff);
						System.out.println("buff length is "+charBuff.length);
						isr.close();
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
			//g.drawString("123", posX, posY);
			return java.awt.print.Printable.PAGE_EXISTS;
		}else{
			return java.awt.print.Printable.NO_SUCH_PAGE;
		}
		//
		//return java.awt.print.Printable.NO_SUCH_PAGE;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final String PGNAME="tryInfilePrintOneTimeEncoding";
		
		//==========
		
		System.out.println("start of "+PGNAME);
		//System.out.println(System.getProperty("file.encoding"));
		java.awt.print.PrinterJob job=java.awt.print.PrinterJob.getPrinterJob();
		job.setPrintable(new tryInfilePrintOneTimeEncoding());
		try{
			job.setJobName(PGNAME);
			job.print();
		}catch(java.awt.print.PrinterException e){
			System.out.println(e.toString());
			System.exit(1);
		}
		System.out.println("end of "+PGNAME);
		
		//==========
		

	}

}
