
package com.Banking.BankingSystem.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.Banking.BankingSystem.Model.Account;
import com.Banking.BankingSystem.Repository.AccountRepository;

@Repository
public class BnkAccountDaoImpl implements AccountDAO {
	@Autowired
	private AccountRepository accountRepository;
	
    @Override
    public Account createAccount(Account account) {
    	return accountRepository.save(account);
    }

    @Override
    public void updateBalance(int accountNumber, double newBalance) {
       
    }

    @Override
    public double getBalance(int accountNumber) {
        double balance = 0.0;
        return balance;
    }

	@Override
	public List<Account> getAllAccounts() {
		return accountRepository.findAll();
	}

	@Override
	public Account getAccountById(int id) {
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Account not exist with id: " + id));
		return account;
	}
	
	@Override
	public Account getAccountById(int id, Account accountDetails) {
        Account account = accountRepository.findById(id)
                .orElse(accountDetails);
        
		return account;
	}

	@Override
	public Account updateAccount(Account account) {
		Account updatedAccount = accountRepository.save(account);
		return updatedAccount;
	}

	@Override
	public Map<String, Boolean> deleteAccount(int id) {
		Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not exist with id: " + id));
        
        accountRepository.delete(account);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
	}
}

