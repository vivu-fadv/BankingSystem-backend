package com.Banking.BankingSystem.Controller;

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
import com.Banking.BankingSystem.DAO.AccountDAO;
import com.Banking.BankingSystem.Model.Account;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // Allow Angular application to access this API
@RequestMapping("/api/v1/")
public class AccountController {
	@Autowired
	private AccountDAO accountDAO;
	
	public AccountController(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	@GetMapping("/welcome")
	public String home() {
		return "Welcome to Banking Management Application";
	}

	// get all accounts
	@GetMapping("/accounts")
	public List<Account> getAllAccounts() {
		return accountDAO.getAllAccounts();
	}
	
	// create account rest api
	@PostMapping("/accounts")
	public Account createAccount(@RequestBody Account account) {
		return accountDAO.createAccount(account);
	}
	
	// get account by id rest api
	@GetMapping("/accounts/{id}")
	public ResponseEntity<Account> getAccountById(@PathVariable Integer id) {
		Account account = accountDAO.getAccountById(id);
		
		return ResponseEntity.ok(account);
	}
	
	// update account rest api
	@PutMapping("/accounts/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable Integer id, @RequestBody Account accountDetails)
	{
		Account account = accountDAO.getAccountById(id, accountDetails);
        
        account.setFirstName(accountDetails.getFirstName());
        account.setLastName(accountDetails.getLastName());
        account.setEmail(accountDetails.getEmail());
        account.setCity(accountDetails.getCity());
        account.setState(accountDetails.getState());
        account.setZip(accountDetails.getZip());
        
        Account updatedAccount = accountDAO.updateAccount(account);
        return ResponseEntity.ok(updatedAccount);
	}
	
	// delete account rest api
	@DeleteMapping("/accounts/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteAccount(@PathVariable Integer id)
    {
        return ResponseEntity.ok(accountDAO.deleteAccount(id));
    }
}

