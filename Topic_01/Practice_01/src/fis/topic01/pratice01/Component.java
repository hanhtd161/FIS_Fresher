package fis.topic01.pratice01;

public class Component {
	private IValidation validation;
	private String data;
	
	public void setValidation(IValidation validation) {
		this.validation = validation;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public void display() {
		System.out.print(data);
	}
	
	public boolean validate() {
		return this.validation.validate(data);
	}
	
	
}
