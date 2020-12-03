package com.bankapp.model.service;

import java.util.List;

import com.bankapp.model.dao.Account;

public interface AccountService {
	public List<Account> getAllAccounts();
	public Account updateAccount(int accountId,Account account);
	public Account deleteAccount(int accountId);
	public Account getAccountById(int accountId);
	public Account addAccount(Account account);
	public void deposit(int accountId,double amount);
	public void withdraw(int accountId,double amount);
	public void transfer(int fromaccountId,int toaccountId,double amount);
	public Account getUser(String username, String password);

}
