package yz.logistic.generic;

public class BlockNo {

	private String blockno;
	
	public BlockNo(){
		this.constructorCommon(mycommons.constants.Generic.CS_SPACE);
	}
	public BlockNo(String blockno){
		this.constructorCommon(blockno);
	}
	private void constructorCommon(String blockno){
		this.blockno=blockno;		
	}
	public String get(){
		return this.blockno;
	}
	public void set(String blockno){
		this.blockno=blockno;
	}
}
