package com.Banking.BankingSystem.DAO;

import java.util.List;
import java.util.Map;

import com.Banking.BankingSystem.DTO.AccountDTO;

public interface AccountDAO {
	AccountDTO createAccount(AccountDTO account);
    void updateBalance(int accountNumber, double newBalance);
    double getBalance(int accountNumber);
	List<AccountDTO> getAllAccounts();
	AccountDTO getAccountById(int id);
	AccountDTO getAccountById(int id, AccountDTO account);
	AccountDTO updateAccount(AccountDTO account);
	Map<String, Boolean> deleteAccount(int id);
	Boolean findByUsernameAndPassword(String username, String password);
}
