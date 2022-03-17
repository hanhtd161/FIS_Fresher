package fis.java.exc01;

import java.util.Date;

public class Main {
	public static void main(String[] args) {
		Record record = new Record();
		record.setTransactionsByReadExcelFile();
		System.out.print(record.checkTransaction("9865321", 7000000, new Date(1000*365*24*3600*52))); 
	}
}
