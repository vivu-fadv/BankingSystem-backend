package com.Banking.BankingSystem.DAO;

import java.util.List;
import java.util.Map;

import com.Banking.BankingSystem.Model.Account;

public interface AccountDAO {
	Account createAccount(Account account);
    void updateBalance(int accountNumber, double newBalance);
    double getBalance(int accountNumber);
	List<Account> getAllAccounts();
	Account getAccountById(int id);
	Account getAccountById(int id, Account account);
	Account updateAccount(Account account);
	Map<String, Boolean> deleteAccount(int id);
}
