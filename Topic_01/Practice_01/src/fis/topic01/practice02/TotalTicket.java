package fis.topic01.practice02;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TotalTicket {
	private static final int TAX_PERCENT = 10;
	private static final int SALARY = 100;
	private Date date;
	private List<payFee> ticketsList = new ArrayList<payFee>();
	
	public TotalTicket() {
	}

	public TotalTicket(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public void addTicket(payFee ticket) {
		this.ticketsList.add(ticket);
	}
	
	public int calculateTotalVehicles() {
		return this.ticketsList.size();
	}
	
	public int calculateTotalFees() {
		int totalFee = 0;
		for(payFee ticket : ticketsList ) {
			totalFee +=ticket.payFeeTicket();
		}
		return totalFee;
	}
	
	public int calculateProfit() {
		int tax = this.calculateTotalFees() * TAX_PERCENT;
		int totalSalary = this.calculateTotalVehicles() * SALARY;
		return this.calculateTotalFees() - tax - totalSalary; 
	}
}
