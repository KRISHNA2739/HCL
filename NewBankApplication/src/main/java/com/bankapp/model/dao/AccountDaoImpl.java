package com.bankapp.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bankapp.model.dao.user.User;

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
		getSession().update(accountToBeUpdated);
		return accountToBeUpdated;
	}

	@Override
	public Account deleteAccount(int accountId) {
		Account accountToBeDeleted = getAccountById(accountId);
		accountToBeDeleted.setAccountStatus(AccountStatus.HOLD);
		getSession().update(accountToBeDeleted);
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

	@Override
	public Account getUser(String username, String password) {
		String hql = "FROM Account U WHERE U.username = :username AND U.password = :password";
		Query query = getSession().createQuery(hql);
		query.setParameter("username", username);
		query.setParameter("password", password);

		return (Account) query.uniqueResult();
		
	}
	

}
