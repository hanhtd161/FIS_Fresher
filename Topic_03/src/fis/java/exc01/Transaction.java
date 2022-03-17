package fis.java.exc01;

import java.util.Date;

public class Transaction {
	private int id;
	private String accountNumberSender;
	private double amount;
	private String message;
	private Date date;
	
	public Transaction() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountNumberSender() {
		return accountNumberSender;
	}

	public void setAccountNumberSender(String accountNumberSender) {
		this.accountNumberSender = accountNumberSender;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	
}
