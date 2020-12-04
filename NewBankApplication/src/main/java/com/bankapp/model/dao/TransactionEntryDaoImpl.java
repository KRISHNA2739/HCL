package com.bankapp.model.dao;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionEntryDaoImpl implements TransactionEntryDao{

	private SessionFactory factory;
	
	@Autowired
	public TransactionEntryDaoImpl(SessionFactory factory) {
		this.factory = factory;
	}
	
	private Session getSession() {
		return factory.getCurrentSession();
	}
	
	@Override
	public void addTransaction(Account fromaccountId,Account toaccountId,String txInfo, Double amount, TxType txType){
		TransactionEntry transactionEntry = new TransactionEntry(fromaccountId,toaccountId,txInfo,new Date(), amount, txType);
		getSession().persist(transactionEntry);
		
	}

	@Override
	public List<TransactionEntry> getTransactionsById(int fromaccountId) {
		
		Query query = getSession().createQuery("from TransactionEntry where fromaccountId.accountId=:accountId or toaccountId=:accountId order by timestamp desc");
		query.setParameter("accountId", fromaccountId);
		List<TransactionEntry> transactionEntries = query.getResultList();
		
		return transactionEntries;
	}

	@Override
	public List<TransactionEntry> getallTransactions() {
		
		return getSession().createQuery("from TransactionEntry").list();
	}
}
