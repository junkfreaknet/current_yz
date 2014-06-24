package yz.logistic.generic;

public class ShippingNo {

	private String shippingno;
	
	public ShippingNo(){
		this.shippingno=mycommons.constants.Generic.CS_SPACE;
	}
	public ShippingNo(String shippingno){
		this.shippingno=shippingno;
	}
	public String get(){
		return shippingno;
	}
	public void set(String shippingno){
		this.shippingno=shippingno;
	}
}
