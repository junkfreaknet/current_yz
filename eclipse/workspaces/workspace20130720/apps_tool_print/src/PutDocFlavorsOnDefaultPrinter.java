
public class PutDocFlavorsOnDefaultPrinter {

	/*
	 * put document flavors on default printer
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		javax.print.PrintService dps=javax.print.PrintServiceLookup.lookupDefaultPrintService();
		javax.print.DocFlavor[] docFlavor_s=javax.print.PrintServiceLookup.lookupDefaultPrintService().getSupportedDocFlavors();
		
		System.out.println("default printer name is "+"\""+dps.getName()+"\"");
		for(int i=0;i<docFlavor_s.length;i++){
			System.out.println(String.valueOf(i+1)+":"+docFlavor_s[i].toString());
		}

	}

}
