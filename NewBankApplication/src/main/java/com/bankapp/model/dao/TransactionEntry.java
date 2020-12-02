package com.bankapp.model.dao;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;



@Entity
@Table(name = "transaction_table")
public class TransactionEntry {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer txId;
	private Integer fromaccountId;
	private Integer toaccountId;
	
    private String txInfo;
    
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    
    private Double amount;
    
    @Enumerated(EnumType.STRING)
    private TxType txType;
    
   
    
	
	public TransactionEntry() {
		
	}
	
	

	


	public TransactionEntry(Integer fromaccountId, Integer toaccountId, String txInfo, Date timestamp, Double amount,
			TxType txType) {
		
		this.fromaccountId = fromaccountId;
		this.toaccountId = toaccountId;
		this.txInfo = txInfo;
		this.timestamp = timestamp;
		this.amount = amount;
		this.txType = txType;
	}






	public Integer getFromaccountId() {
		return fromaccountId;
	}

	public void setFromaccountId(Integer fromaccountId) {
		this.fromaccountId = fromaccountId;
	}

	public Integer getToaccountId() {
		return toaccountId;
	}

	public void setToaccountId(Integer toaccountId) {
		this.toaccountId = toaccountId;
	}

	public Integer getTxId() {
		return txId;
	}

	public void setTxId(Integer txId) {
		this.txId = txId;
	}

	public String getTxInfo() {
		return txInfo;
	}

	public void setTxInfo(String txInfo) {
		this.txInfo = txInfo;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	
	public TxType getTxType() {
		return txType;
	}

	public void setTxType(TxType txType) {
		this.txType = txType;
	}






	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TransactionEntry [txId=");
		builder.append(txId);
		builder.append(", fromaccountId=");
		builder.append(fromaccountId);
		builder.append(", toaccountId=");
		builder.append(toaccountId);
		builder.append(", txInfo=");
		builder.append(txInfo);
		builder.append(", timestamp=");
		builder.append(timestamp);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", txType=");
		builder.append(txType);
		builder.append("]");
		return builder.toString();
	}
	
	
}
