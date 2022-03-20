package fis.topic01.practice02;

public class MotorTicket implements payFee {
	private int code;
	private String licensePlate;
	private int fee = CONSTANT.MOTOR_FEE.FEE;
	
	public MotorTicket() {
	}

	public MotorTicket(int code, String licensePlate) {
		this.code = code;
		this.licensePlate = licensePlate;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	@Override
	public int payFeeTicket() {
		return this.fee;
	}

}
