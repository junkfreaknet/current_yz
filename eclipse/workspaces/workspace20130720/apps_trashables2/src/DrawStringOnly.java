
public class DrawStringOnly implements java.awt.print.Printable{

	boolean isFirst=true;
	
	public int print(java.awt.Graphics g,java.awt.print.PageFormat pf ,int page) throws java.awt.print.PrinterException{
		if(page<2){

			g.drawString("abc", (int)pf.getImageableX(),(int)pf.getImageableY());
			return java.awt.print.Printable.PAGE_EXISTS;
		}else{
			return java.awt.print.Printable.NO_SUCH_PAGE;
		}
		/***
		if(isFirst==true){
			isFirst=false;
			g.drawString("abc", (int)pf.getImageableX(),(int)pf.getImageableY());
			return java.awt.print.Printable.PAGE_EXISTS;
		}else{
			return java.awt.print.Printable.NO_SUCH_PAGE;
		}
		***/
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		java.awt.print.PrinterJob pj=java.awt.print.PrinterJob.getPrinterJob();
		pj.setJobName("DrawStringOnly");
		pj.setPrintable(new DrawStringOnly());
		try{
		pj.print();
		}catch(java.awt.print.PrinterException e){
			System.out.println(e.toString());
			System.exit(1);
		}
	}

}
