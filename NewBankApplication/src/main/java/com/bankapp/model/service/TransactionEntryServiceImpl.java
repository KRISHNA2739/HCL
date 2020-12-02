package com.bankapp.model.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.model.dao.Account;
import com.bankapp.model.dao.AccountDao;
import com.bankapp.model.dao.TransactionEntry;
import com.bankapp.model.dao.TransactionEntryDao;
import com.bankapp.model.dao.TxType;

@Service("transactionEntryService")
@Transactional
public class TransactionEntryServiceImpl implements TransactionEntryService{

	private TransactionEntryDao transactionEntryDao;
	
	@Autowired
	public TransactionEntryServiceImpl(TransactionEntryDao transactionEntryDao) {
	
		this.transactionEntryDao = transactionEntryDao;
	}

	@Override
	public void addTransaction(Account fromaccountId,Account toaccountId,String txInfo, Double amount, TxType txType) {
		transactionEntryDao.addTransaction(fromaccountId,toaccountId,txInfo, amount, txType);
	}



	@Override
	public List<TransactionEntry> getTransactionsById(int accountId) {
		return transactionEntryDao.getTransactionsById(accountId);
	}

	@Override
	public List<TransactionEntry> getallTransactions() {
		
		return transactionEntryDao.getallTransactions();
	}

}
