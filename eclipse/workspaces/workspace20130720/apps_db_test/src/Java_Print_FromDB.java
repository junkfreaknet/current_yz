import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Java_Print_FromDB implements java.awt.print.Printable{

    Connection con=null;
    Statement stmnt=null;
    ResultSet rs=null;
    boolean status;
    
	//constructor
	public Java_Print_FromDB(){
        
		this.status=false;
		String sql_string="select distinct "+
                "jigyo_cd,"+
                "syu_ymd,"+
                "bin_kb"+
                " from dbo.tbl_outfile"+
                " order by syu_ymd,bin_kb"+
                "";	
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			try{
				con=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;"+ //localost---> 127.0.0.1
						"instanceName=SQLEXPRESS;"+
						"databaseName=testDB;"+
						"user=sa;"+
						"password=noriyuki");
				stmnt=con.createStatement();
				rs=stmnt.executeQuery(sql_string);
				this.status=true;
			}catch(java.sql.SQLException e){
				System.out.println(e.toString());
				System.exit(1);
			}
		}catch(ClassNotFoundException e){
			System.out.println(e.toString());
			System.exit(1);
		}
	}
	//print
	public int print(java.awt.Graphics g,java.awt.print.PageFormat pf,int page) throws java.awt.print.PrinterException{
		
		boolean isContinue=true;
		if(!this.status){
			System.out.println("status is "+String.valueOf(this.status));
			System.out.println("exit print() ... ");
			return java.awt.print.Printable.NO_SUCH_PAGE;
		}
		try{
			isContinue=this.rs.next();
			if(isContinue){
				System.out.println(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3));
				return java.awt.print.Printable.PAGE_EXISTS;
			}else{
				return java.awt.print.Printable.NO_SUCH_PAGE;
			}
		}catch(java.sql.SQLException e){
			System.out.println("SQLException occurs.");
			System.out.println("status is "+String.valueOf(this.status));
			System.out.println("exit print() ... ");
			return java.awt.print.Printable.NO_SUCH_PAGE;
		}
	}
}
