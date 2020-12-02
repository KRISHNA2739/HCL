package com.bankapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.dao.Account;
import com.bankapp.model.dao.AccountDao;
import com.bankapp.model.dao.TxType;

@Service(value = "bs")
@Transactional
public class AccountServiceImpl implements AccountService {

	private AccountDao accountdao;
	private TransactionEntryService transactionentryservice;

	@Autowired
	public AccountServiceImpl(AccountDao accountdao, TransactionEntryService transactionentryservice) {

		this.accountdao = accountdao;
		this.transactionentryservice = transactionentryservice;
	}

	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return accountdao.getAllAccounts();
	}

	@Override
	public Account updateAccount(int accountId, Account account) {
		// TODO Auto-generated method stub
		return accountdao.updateAccount(accountId, account);
	}

	@Override
	public Account deleteAccount(int accountId) {
		// TODO Auto-generated method stub
		return accountdao.deleteAccount(accountId);
	}

	@Override
	public Account getAccountById(int accountId) {
		// TODO Auto-generated method stub
		return accountdao.getAccountById(accountId);
	}

	@Override
	public Account addAccount(Account account) {
		// TODO Auto-generated method stub
		return accountdao.addAccount(account);
	}

	@Override
	public void deposit(int accountId, double amount) {
		Account account = accountdao.getAccountById(accountId);
		account.setBalance(account.getBalance() + amount);
		accountdao.updateAccount(account);
		transactionentryservice.addTransaction(account,account," deposit in "+ accountId, amount, TxType.DEPOSIT);
		

	}

	@Override
	public void withdraw(int accountId, double amount) {
		Account account = accountdao.getAccountById(accountId);
		account.setBalance(account.getBalance() - amount);
		accountdao.updateAccount(account);
		transactionentryservice.addTransaction(account,account," withdraw from "+ accountId, amount, TxType.WITHDRAW);
	}

	@Override
	public void transfer(int fromaccountId, int toaccountId, double amount) {
		Account account1 = accountdao.getAccountById(fromaccountId);
		account1.setBalance(account1.getBalance() - amount);
		accountdao.updateAccount(account1);
		Account account = accountdao.getAccountById(toaccountId);
		account.setBalance(account.getBalance() + amount);
		accountdao.updateAccount(account);
		transactionentryservice.addTransaction(account1,account," withdraw from "+ fromaccountId+" deposit in "+ toaccountId, amount, TxType.TRANSFER);
	}

}
