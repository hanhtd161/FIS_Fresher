package fis.topic01.pratice01;

import java.util.regex.Pattern;

public class DecimalValidation implements IValidation {

	@Override
	public boolean validate(String data) {
		
		return Pattern.matches("^[0-9]+\\.[0-9]+$", data);
	}

}
