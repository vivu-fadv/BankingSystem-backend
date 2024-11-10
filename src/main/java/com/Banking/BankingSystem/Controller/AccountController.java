package com.Banking.BankingSystem.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Banking.BankingSystem.Model.Account;
import com.Banking.BankingSystem.Repository.AccountRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // Allow Angular application to access this API
@RequestMapping("/api/v1/")
public class AccountController {
	@Autowired
	private AccountRepository accountRepository;

	@GetMapping("/welcome")
	public String home() {
		return "Welcome to Banking Management System";
	}

	// get all accounts
	@GetMapping("/accounts")
	public List<Account> getAllAccounts() {
		return accountRepository.findAll();
	}
	
	// create account rest api
	@PostMapping("/accounts")
	public Account createAccount(@RequestBody Account account) {
		return accountRepository.save(account);
	}
	
	// get account by id rest api
	@GetMapping("/accounts/{id}")
	public ResponseEntity<Account> getAccountById(@PathVariable Integer id) {
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Account not exist with id: " + id));
		
		return ResponseEntity.ok(account);
	}
	
	// update account rest api
	@PutMapping("/accounts/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable Integer id, @RequestBody Account accountDetails)
	{
        Account account = accountRepository.findById(id)
                .orElse(accountDetails);
        
        account.setFirstName(accountDetails.getFirstName());
        account.setLastName(accountDetails.getLastName());
        account.setEmail(accountDetails.getEmail());
        
        Account updatedAccount = accountRepository.save(account);
        return ResponseEntity.ok(updatedAccount);
	}
	
	// delete account rest api
	@DeleteMapping("/accounts/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteAccount(@PathVariable Integer id)
    {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not exist with id: " + id));
        
        accountRepository.delete(account);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}

