package com.bankapp.web.formbeans;

public class WithdrawBean {
	

	private Double amount;
	
	public WithdrawBean( Double amount) {
		
		
		this.amount = amount;
	}
	
	public WithdrawBean() {
	}
	

	
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
}
