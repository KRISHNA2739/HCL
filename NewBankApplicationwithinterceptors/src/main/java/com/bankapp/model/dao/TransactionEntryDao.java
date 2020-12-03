package com.bankapp.model.dao;

import java.util.List;

public interface TransactionEntryDao {

	public void addTransaction(Account fromaccountId,Account toaccountId,String txInfo, Double amount, TxType txType);
	public List<TransactionEntry> getTransactionsById(int fromaccountId);
	public List<TransactionEntry> getallTransactions();
	
}
