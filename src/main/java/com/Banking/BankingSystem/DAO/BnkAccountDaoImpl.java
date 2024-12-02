
package com.Banking.BankingSystem.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.Banking.BankingSystem.DTO.AccountDTO;
import com.Banking.BankingSystem.Model.Account;
import com.Banking.BankingSystem.Repository.AccountRepository;

@Repository
public class BnkAccountDaoImpl implements AccountDAO {
	@Autowired
	private AccountRepository accountRepository;
	
    @Override
    public AccountDTO createAccount(AccountDTO accountDTO) {
    	Account saveAccount = new Account();
    	saveAccount.setBalance(accountDTO.getBalance());
    	saveAccount.setCity(accountDTO.getCity());
    	saveAccount.setEmail(accountDTO.getEmail());
    	saveAccount.setFirstName(accountDTO.getFirstName());
    	saveAccount.setLastName(accountDTO.getLastName());
    	saveAccount.setState(accountDTO.getState());
    	saveAccount.setZip(accountDTO.getZip());
    	saveAccount.setUsername(accountDTO.getUsername());
    	saveAccount.setPassword(accountDTO.getPassword());
    	saveAccount.setIsAdmin(false);
    	var result = accountRepository.save(saveAccount);
    	accountDTO.setId(result.getId());
    	return accountDTO;
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
	public List<AccountDTO> getAllAccounts() {
		List<AccountDTO> accountListDTO = new ArrayList<>();
		var accountList = accountRepository.findAll();
		for (Account account : accountList) {
		    AccountDTO accountDTO = new AccountDTO();
		    accountDTO.setId(account.getId());
		    accountDTO.setBalance(account.getBalance());
		    accountDTO.setCity(account.getCity());
		    accountDTO.setEmail(account.getEmail());
		    accountDTO.setFirstName(account.getFirstName());
		    accountDTO.setLastName(account.getLastName());
		    accountDTO.setState(account.getState());
		    accountDTO.setZip(account.getZip());
		    accountDTO.setUsername(account.getUsername());
		    accountDTO.setPassword(account.getPassword());
		    accountDTO.setIsAdmin(account.getIsAdmin());
		    accountListDTO.add(accountDTO);
		}
		
		return accountListDTO;
	}

	@Override
	public AccountDTO getAccountById(int id) {
		AccountDTO accountDTO = new AccountDTO();
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Account not exist with id: " + id));
		accountDTO.setId(account.getId());
		accountDTO.setBalance(account.getBalance());
		accountDTO.setCity(account.getCity());
		accountDTO.setEmail(account.getEmail());
		accountDTO.setFirstName(account.getFirstName());
	    accountDTO.setLastName(account.getLastName());
	    accountDTO.setState(account.getState());
	    accountDTO.setZip(account.getZip());
	    accountDTO.setUsername(account.getUsername());
	    accountDTO.setIsAdmin(account.getIsAdmin());
	    accountDTO.setPassword(account.getPassword());
		return accountDTO;
	}
	
	@Override
	public AccountDTO getAccountById(int id, AccountDTO accountDetailsDTO) {
		Account accountDetails = new Account();
		accountDetails.setId(accountDetailsDTO.getId());
		accountDetails.setBalance(accountDetailsDTO.getBalance());
		accountDetails.setCity(accountDetailsDTO.getCity());
		accountDetails.setEmail(accountDetailsDTO.getEmail());
		accountDetails.setFirstName(accountDetailsDTO.getFirstName());
		accountDetails.setLastName(accountDetailsDTO.getLastName());
		accountDetails.setState(accountDetailsDTO.getState());
		accountDetails.setZip(accountDetailsDTO.getZip());
		accountDetails.setIsAdmin(accountDetailsDTO.getIsAdmin());
		accountDetails.setUsername(accountDetailsDTO.getUsername());
		accountDetails.setPassword(accountDetailsDTO.getPassword());
        Account account = accountRepository.findById(id)
                .orElse(accountDetails);
        
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(account.getId());
        accountDTO.setBalance(account.getBalance());
        accountDTO.setCity(account.getCity());
        accountDTO.setEmail(account.getEmail());
        accountDTO.setFirstName(account.getFirstName());
        accountDTO.setLastName(account.getLastName());
        accountDTO.setState(account.getState());
        accountDTO.setZip(account.getZip());
        accountDTO.setIsAdmin(account.getIsAdmin());
        accountDTO.setUsername(account.getUsername());
        accountDTO.setPassword(account.getPassword());
       
		return accountDTO;
	}

	@Override
	public AccountDTO updateAccount(AccountDTO accountDTO) {
		Account account = new Account();
		account.setId(accountDTO.getId());
		account.setBalance(accountDTO.getBalance());
		account.setCity(accountDTO.getCity());
		account.setEmail(accountDTO.getEmail());
		account.setFirstName(accountDTO.getFirstName());
		account.setLastName(accountDTO.getLastName());
		account.setState(accountDTO.getState());
		account.setZip(accountDTO.getZip());
		account.setUsername(accountDTO.getUsername());
		account.setPassword(accountDTO.getPassword());
		account.setIsAdmin(accountDTO.getIsAdmin());
		
		Account updatedAccount = accountRepository.save(account);
		AccountDTO updatedAccountDTO = new AccountDTO();
		updatedAccountDTO.setId(updatedAccount.getId());
		updatedAccountDTO.setBalance(updatedAccount.getBalance());
		updatedAccountDTO.setCity(updatedAccount.getCity());
		updatedAccountDTO.setEmail(updatedAccount.getEmail());
		updatedAccountDTO.setFirstName(updatedAccount.getFirstName());
	    updatedAccountDTO.setLastName(updatedAccount.getLastName());
	    updatedAccountDTO.setState(updatedAccount.getState());
	    updatedAccountDTO.setZip(updatedAccount.getZip());
	    updatedAccountDTO.setUsername(updatedAccount.getUsername());
	    updatedAccountDTO.setPassword(updatedAccount.getPassword());
	    updatedAccountDTO.setIsAdmin(updatedAccount.getIsAdmin());
		return updatedAccountDTO;
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
	
	@Override
	public AccountDTO findByUsernameAndPassword(String username, String password) {
		List<Account> account = accountRepository.findByUsernameAndPassword(username, password);
		if(account.isEmpty()) {
            return null;
		}
		
		AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(account.get(0).getId());
        accountDTO.setBalance(account.get(0).getBalance());
        accountDTO.setCity(account.get(0).getCity());
        accountDTO.setEmail(account.get(0).getEmail());
        accountDTO.setFirstName(account.get(0).getFirstName());
        accountDTO.setLastName(account.get(0).getLastName());
        accountDTO.setState(account.get(0).getState());
        accountDTO.setZip(account.get(0).getZip());
        accountDTO.setIsAdmin(account.get(0).getIsAdmin());
        accountDTO.setUsername(account.get(0).getUsername());
        accountDTO.setPassword(account.get(0).getPassword());
		return accountDTO;
	}
}

