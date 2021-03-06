package fis.topic01.practice02;

public class BicycleTicket implements payFee {
	
	private int code;
	private int fee = CONSTANT.BICYCLE_FEE.FEE;
	
	public BicycleTicket() {
	}
	public BicycleTicket(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	@Override
	public int payFeeTicket() {
		return this.fee;
	}

}
