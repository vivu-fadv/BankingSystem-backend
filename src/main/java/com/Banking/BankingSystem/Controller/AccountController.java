package com.Banking.BankingSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Banking.BankingSystem.Model.Account;
import com.Banking.BankingSystem.Repository.AccountRepository;

@RestController
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
}
