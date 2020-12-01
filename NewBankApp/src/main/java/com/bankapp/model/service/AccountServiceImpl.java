package com.bankapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.dao.Account;
import com.bankapp.model.dao.AccountDao;

@Service(value="bs")
@Transactional
public class AccountServiceImpl implements AccountService{
	
	private AccountDao accountdao;
	@Autowired
	public AccountServiceImpl(AccountDao accountdao) {
		
		this.accountdao = accountdao;
	}

	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return accountdao.getAllAccounts();
	}

	@Override
	public Account updateAccount(int accountId,Account account) {
		// TODO Auto-generated method stub
		return accountdao.updateAccount(accountId,account);
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
		Account account =accountdao.getAccountById(accountId);
		account.setBalance(account.getBalance()+amount);
		accountdao.updateAccount(account);
		
	}

	@Override
	public void withdraw(int accountId, double amount) {
		Account account =accountdao.getAccountById(accountId);
		account.setBalance(account.getBalance()-amount);
		accountdao.updateAccount(account);
		
	}

	@Override
	public void transfer(int fromaccountId, int toaccountId, double amount) {
		withdraw(fromaccountId,amount);
		deposit(toaccountId,amount);
		
	}

	

}
