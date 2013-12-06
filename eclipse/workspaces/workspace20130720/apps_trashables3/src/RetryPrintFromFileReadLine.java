
public class RetryPrintFromFileReadLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final String INFILE=".\\inFiles/in.txt";
		java.io.FileReader fr=null;
		String strBuff="";
		int i;
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
				System.out.println(String.valueOf(i)+":"+strBuff);
			}catch(java.io.IOException e){
				System.out.println(e.toString());
				System.exit(1);
			}
		}
		//20130731
		System.out.println("line count is "+String.valueOf(i));
	}

}
