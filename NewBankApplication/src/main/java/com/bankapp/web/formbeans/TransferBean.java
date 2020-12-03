package com.bankapp.web.formbeans;

public class TransferBean {
	

	private Integer toAccountId;
	private Double amount;
	
	public TransferBean() {
	}

	
	public Integer getToAccountId() {
		return toAccountId;
	}

	public void setToAccountId(Integer toAccountId) {
		this.toAccountId = toAccountId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public TransferBean( Integer toAccountId, Double amount) {
		
	
		this.toAccountId = toAccountId;
		this.amount = amount;
	}
}
