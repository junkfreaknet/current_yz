package mycommons.returns.Complex;

public class StatString {
	
	boolean status;
	String rv;
	
	public void setStatus(boolean in){
		this.status=in;
	}
	public void setReturn(String in){
		this.rv=in;
	}
	public boolean getStatus(){
		return this.status;
	}
	public String getResult(){
		return this.rv;
	}
}
