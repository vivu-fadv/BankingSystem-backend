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
	
	@Column(name = "username")	// JPA annotation to specify the column
	private String username;
	
	// @Column(name = "customer_name")	// JPA annotation to specify the column
	// private String fir + String lastname;

	@Column(name = "balance")	// JPA annotation to specify the column
	//@Min(value = 100, message = "Balance must be at least 100")
	private double balance;
	
	@Column(name = "first_name")	// JPA annotation to specify the column
	private String firstName;
	
	@Column(name = "last_name")	// JPA annotation to specify the column
	private String lastName;
	
	@Column(name = "email")	// JPA annotation to specify the column
	private String email;
	
	@Column(name = "city")	// JPA annotation to specify the column
	private String city;
	
	@Column(name = "state")	// JPA annotation to specify the column")
	private String state;
	
	@Column(name = "zip")	// JPA annotation to specify the column")
	private String zip;
	
	public Account() {

	}

	public Account(Integer id, String username, double balance, String firstName, String lastName, String email, String city, String state, String zip) {
		super();
		this.id = id;
		this.username = username;
		this.balance = balance;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.city = city;
		this.state = state;
		this.zip = zip;
		//this.username = username;
	}

	public Integer getId() {
		return id;
	}

	public String getUsername() {
		return username;
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
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public String getZip() {
		return zip;
	}

	@Override
	public String toString() {
		return "Account Number: " + id + ", Username: " + username + ", Balance: " + balance + ", First Name: " + firstName + ", Last Name: " + lastName + ", Email: " + email;
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

	//Added a setBalance setter to show the balance in the createaccount
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public void setZip(String zip) {
		this.zip = zip;
	}

	public void setUserName(String username) {
		// TODO Auto-generated method stub
		this.username = username;
	}
}
