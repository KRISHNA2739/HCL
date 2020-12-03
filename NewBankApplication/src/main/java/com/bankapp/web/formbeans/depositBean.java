package com.bankapp.web.formbeans;

public class depositBean {
	
	private Integer accountId;
	private Double amount;
	
	public depositBean(Integer accountId, Double amount) {
		
		this.accountId = accountId;
		this.amount = amount;
	}
	
	public depositBean() {
	}
	
	public Integer getAccountId() {
		return accountId;
	}
	
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WithdrawBean [accountId=");
		builder.append(accountId);
		builder.append(", amount=");
		builder.append(amount);
		builder.append("]");
		return builder.toString();
	}
}
