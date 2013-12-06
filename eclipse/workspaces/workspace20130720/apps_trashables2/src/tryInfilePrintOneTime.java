//import java.io.F		final String INFILE=".\\inFiles/in.txt";


public class tryInfilePrintOneTime implements java.awt.print.Printable{

	int cntCall=0;
	
	public int print(java.awt.Graphics g,java.awt.print.PageFormat pf,int page) throws java.awt.print.PrinterException{

		final String INFILE=".\\inFiles/in.txt";
		int buffSize=0;
		java.io.FileReader fr=null;
		int inBuff=0;
		int inCnt;
	
		int posX;
		int posY;
		String encoding;
		
		//get num of charachers in file
		System.out.println("page is "+String.valueOf(page)+" call cnt is "+String.valueOf(cntCall));
		System.out.println(System.getProperty("file.encoding"));
		encoding=System.getProperty("file.encoding");
		
		if(cntCall==0){
		//if(page<2){
			try{
				fr=new java.io.FileReader(INFILE);
				try{
					for(buffSize=0;inBuff!=-1;buffSize++){
						inBuff=fr.read();					
					}
					fr.close();
				
				}catch(java.io.IOException e){
					System.out.println(e.toString());
					System.exit(1);
			}
			}catch(java.io.FileNotFoundException e){
				System.out.println(e.toString());
				System.exit(1);			
			}
			try{
				char[] cBuff=new char[buffSize];
				fr=new java.io.FileReader(INFILE);
				try{
					inCnt=fr.read(cBuff);
					//System.out.println(cBuff);
					posX=(int)pf.getImageableX()+g.getFont().getSize();
					posY=(int)pf.getImageableY()+g.getFont().getSize();
					//draw document only one time.
					System.out.println(String.valueOf(cBuff));
					//for(int idx=0;idx<buffSize;idx++){
						g.drawString(String.valueOf(cBuff), posX, posY);
					//}

				}catch(java.io.IOException e){
					System.out.println(e.toString());
					System.exit(1);
				}

			}catch(java.io.FileNotFoundException e){
				System.out.println(e.toString());
				System.exit(1);
			}		
			//the first time "call print()" returns PAGE_EXIST.
			cntCall=cntCall+1;
			return java.awt.print.Printable.PAGE_EXISTS;
		}else{
			cntCall=cntCall+1;
			return java.awt.print.Printable.NO_SUCH_PAGE;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final String PGNAME="tryInfilePrintOneTime";
		
		//==========
		
		System.out.println("start of "+PGNAME);
		//System.out.println(System.getProperty("file.encoding"));
		java.awt.print.PrinterJob job=java.awt.print.PrinterJob.getPrinterJob();
		job.setPrintable(new tryInfilePrintOneTime());
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
