import java.io.FileReader;


public class tryInfile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String PGNAME="tryInfile";
		final String INFILE=".\\inFiles/in.txt";
		int buffSize=0;
		java.io.FileReader fr=null;
		int inBuff=0;
		int inCnt;
		System.out.println("start of "+PGNAME);
		//get num of charachers in file
		try{
			fr=new java.io.FileReader(INFILE);
			try{
				for(buffSize=0;inBuff!=-1;buffSize++){
					inBuff=fr.read();					
				}

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
				System.out.println(cBuff);
			}catch(java.io.IOException e){
				System.out.println(e.toString());
				System.exit(1);
			}
			System.out.println("end of "+PGNAME);
		}catch(java.io.FileNotFoundException e){
			System.out.println(e.toString());
			System.exit(1);
		}
	}

}
