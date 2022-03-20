package fis.topic01.pratice01;

public class StringMaxLengthValidation implements IValidation {
	
	private int length;
	
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public StringMaxLengthValidation(int length) {
		this.length = length;
	}

	@Override
	public boolean validate(String data) {
		if(data.length() <= length) {
			return true;
		}
		return false;
	}

}
