package com.bankapp.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao{

	private SessionFactory factory;
	
	@Autowired
	public AccountDaoImpl(SessionFactory factory) {
		this.factory = factory;
	}
	
	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public List<Account> getAllAccounts() {
		return getSession().createQuery("from Account").getResultList();
	}

	@Override
	public Account updateAccount(int accountId,Account account) {
		Account accountToBeUpdated = getAccountById(accountId);
		accountToBeUpdated.setBalance(account.getBalance());
		accountToBeUpdated.setAddress(account.getAddress());
		accountToBeUpdated.setPhone(account.getPhone());
		getSession().update(accountToBeUpdated);
		return accountToBeUpdated;
	}

	@Override
	public Account deleteAccount(int accountId) {
		Account accountToBeDeleted = getAccountById(accountId);
		getSession().delete(accountToBeDeleted);
		return accountToBeDeleted;
	}

	@Override
	public Account getAccountById(int accountId) {
		Account account = getSession().get(Account.class, accountId);
		return account;
	}

	@Override
	public Account addAccount(Account account) {
		getSession().save(account);
		return account;
	}

	@Override
	public Account updateAccount(Account account) {
		Account accountToBeUpdated = getAccountById(account.getAccountId());
		getSession().update(accountToBeUpdated);
		return accountToBeUpdated;
	}
	

}
