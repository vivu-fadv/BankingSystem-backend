package com.Banking.BankingSystem.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.Banking.BankingSystem.DTO.AccountDTO;
import com.Banking.BankingSystem.DTO.UserRequestDTO;

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
	@GetMapping("/accounts/{id}/getall")
	public List<AccountDTO> getAllAccounts(@PathVariable Integer id) {
		List<AccountDTO> accountListDTO = new ArrayList<>();
		AccountDTO account = accountDAO.getAccountById(id);
		if (account != null && account.getIsAdmin()) {
			return accountDAO.getAllAccounts();
		}

		accountListDTO.add(accountDAO.getAccountById(id));
		return accountListDTO;
	}

	// create account rest api
	@PostMapping("/accounts")
	public AccountDTO createAccount(@RequestBody AccountDTO account) {
		return accountDAO.createAccount(account);
	}

	// get account by id rest api
	@GetMapping("/accounts/{id}")
	public ResponseEntity<AccountDTO> getAccountById(@PathVariable Integer id) {
		AccountDTO account = accountDAO.getAccountById(id);

		return ResponseEntity.ok(account);
	}

	// update account rest api
	@PutMapping("/accounts/{id}")
	public ResponseEntity<AccountDTO> updateAccount(@PathVariable Integer id, @RequestBody AccountDTO accountDetails) {
		AccountDTO account = accountDAO.getAccountById(id, accountDetails);

		account.setFirstName(accountDetails.getFirstName());
		account.setLastName(accountDetails.getLastName());
		account.setEmail(accountDetails.getEmail());
		account.setCity(accountDetails.getCity());
		account.setState(accountDetails.getState());
		account.setZip(accountDetails.getZip());

		AccountDTO updatedAccount = accountDAO.updateAccount(account);
		return ResponseEntity.ok(updatedAccount);
	}

	// Update account balance REST API
	@PutMapping("/accounts/{id}/balance")
	public ResponseEntity<AccountDTO> updateAccountBalance(@PathVariable Integer id,
			@RequestBody Map<String, Double> payload) {

		Double balance = payload.get("balance");
		AccountDTO account = accountDAO.getAccountById(id);
		account.setBalance(balance);
		AccountDTO updatedAccount = accountDAO.updateAccount(account);
		return ResponseEntity.ok(updatedAccount);

	}

	// Depositing amount
	@PutMapping("/accounts/{id}/deposit")
	public ResponseEntity<AccountDTO> depositAmount(@PathVariable Integer id,
			@RequestBody Map<String, Double> payload) {

		double depositAmount = payload.get("amount");
		AccountDTO account = accountDAO.getAccountById(id);
		account.setBalance(account.getBalance() + depositAmount);
		AccountDTO updatedAccount = accountDAO.updateAccount(account);

		return ResponseEntity.ok(updatedAccount);
	}

	@PutMapping("/accounts/{id}/withdraw")
	public ResponseEntity<AccountDTO> withdrawAmount(@PathVariable Integer id,
			@RequestBody Map<String, Double> payload) {
		double withdrawAmount = payload.get("amount");
		AccountDTO account = accountDAO.getAccountById(id);

		if (account.getBalance() >= withdrawAmount) {
			account.setBalance(account.getBalance() - withdrawAmount); // Deduct the balance
			AccountDTO updatedAccount = accountDAO.updateAccount(account);
			return ResponseEntity.ok(updatedAccount);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // Handle insufficient funds
		}
	}

	// delete account rest api
	@DeleteMapping("/accounts/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteAccount(@PathVariable Integer id) {
		return ResponseEntity.ok(accountDAO.deleteAccount(id));
	}

	// get authenticate
	@PostMapping("/accounts/login")
	public ResponseEntity<Integer> getAuthenticate(@RequestBody UserRequestDTO user) {
		return ResponseEntity.ok(accountDAO.findByUsernameAndPassword(user.getUsername(), user.getPassword()));
	}

	// sign up user
	@PostMapping("/accounts/signup")
	public ResponseEntity<Boolean> signupAccount(@RequestBody UserRequestDTO user) {
		if (accountDAO.findByUsernameAndPassword(user.getUsername(), user.getPassword()) > 0) {
			return ResponseEntity.ok(false);
		} else {
			AccountDTO account = new AccountDTO();
			account.setUsername(user.getUsername());
			account.setPassword(user.getPassword());
			account.setEmail(user.getEmail());
			accountDAO.createAccount(account);
			if (account.getId() == 0) {
				return ResponseEntity.ok(false);
			}
			return ResponseEntity.ok(true);
		}
	}
}
