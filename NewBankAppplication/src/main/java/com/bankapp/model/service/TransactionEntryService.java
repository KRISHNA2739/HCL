package com.bankapp.model.service;

import java.util.List;

import com.bankapp.model.dao.Account;
import com.bankapp.model.dao.TransactionEntry;
import com.bankapp.model.dao.TxType;

public interface TransactionEntryService {
	public void addTransaction(Account fromaccountId,Account toaccountId,String txInfo, Double amount, TxType txType);
	public List<TransactionEntry> getTransactionsById(int fromaccountId);
	public List<TransactionEntry> getallTransactions();
}
