
public class RetryPrintFromFileReadLine_2 implements java.awt.print.Printable{

	public int print(java.awt.Graphics g,java.awt.print.PageFormat pf,int page) throws java.awt.print.PrinterException{
		
		final String INFILE=".\\inFiles/in.txt";
		java.io.FileReader fr=null;
		String strBuff="";
		int i;
		int posx;
		int posy;
		java.awt.FontMetrics fm=g.getFontMetrics();
		int height=fm.getHeight();;
		
		posx=(int)pf.getImageableX();
		posy=(int)pf.getImageableY()+height;

		
		if(page==0){
		try{
			fr=new java.io.FileReader(INFILE);
		}catch(java.io.FileNotFoundException e){
			System.out.println(e.toString());
			System.exit(1);
		}
		java.io.BufferedReader bfr=new java.io.BufferedReader(fr);
		for(i=0;strBuff!=null;i++){
			try{
				strBuff=bfr.readLine();
				if(strBuff==null){
					break;
				}
				g.drawString(strBuff, posx, posy);
				posy=posy+height;
				System.out.println(String.valueOf(i)+":"+strBuff);
			}catch(java.io.IOException e){
				System.out.println(e.toString());
				System.exit(1);
			}
		}
			return java.awt.print.Printable.PAGE_EXISTS;
		}else{
			return java.awt.print.Printable.NO_SUCH_PAGE;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		
		//=====
		String PGNAME="RetryPrintFromFileReadLine_2";
		java.awt.print.PrinterJob pj=java.awt.print.PrinterJob.getPrinterJob();
		pj.setJobName(PGNAME);
		pj.setPrintable(new RetryPrintFromFileReadLine_2());
		try{
			pj.print();
		}catch(java.awt.print.PrinterException e){
			System.out.println(e.toString());
			System.exit(1);
		}
	}

}
