package fis.topic01.pratice01;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateValidation implements IValidation {
	
	//dd-mm-yyyy
	private String format;
	
	public DateValidation(String format) {
		this.format = format;
	}

	@Override
	public boolean validate(String data) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(data);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}

}
