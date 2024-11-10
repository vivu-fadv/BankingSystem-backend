package com.Banking.BankingSystem.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity	// JPA annotation to indicate that this class is an entity
@Table(name = "accounts")	// JPA annotation to specify the table name
public class Account {
	@Id	// JPA annotation to specify the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// JPA annotation to specify the generation strategy
	private Integer id;
	
	@Column(name = "account_holder")	// JPA annotation to specify the column
	private String accountHolder;
	
	@Column(name = "balance")	// JPA annotation to specify the column
	private double balance;
	
	@Column(name = "first_name")	// JPA annotation to specify the column
	private String firstName;
	
	@Column(name = "last_name")	// JPA annotation to specify the column
	private String lastName;
	
	@Column(name = "email")	// JPA annotation to specify the column
	private String email;
	
	public Account() {

	}

	public Account(Integer id, String accountHolder, double balance, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.accountHolder = accountHolder;
		this.balance = balance;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public void withdraw(double amount) {
		balance -= amount;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Account Number: " + id + ", Account Holder: " + accountHolder + ", Balance: " + balance + ", First Name: " + firstName + ", Last Name: " + lastName + ", Email: " + email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		// TODO Auto-generated method stub
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		// TODO Auto-generated method stub
		this.email = email;
	}
}
