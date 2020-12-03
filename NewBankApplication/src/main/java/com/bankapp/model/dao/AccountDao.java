package com.bankapp.model.dao;

import java.util.List;

import com.bankapp.model.dao.user.User;

public interface AccountDao {
	
	public List<Account> getAllAccounts();
	public Account updateAccount(int accountId,Account account);
	public Account deleteAccount(int accountId);
	public Account getAccountById(int accountId);
	public Account addAccount(Account account);
	public Account updateAccount(Account account);
	public Account getUser(String username, String password);
}
