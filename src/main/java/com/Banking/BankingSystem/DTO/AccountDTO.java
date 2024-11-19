package com.Banking.BankingSystem.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class AccountDTO {
	    @Id
	    private Integer id;

	    @Column(name = "username")
	    private String username;

	    @Column(name = "balance")
	    // @Min(value = 100, message = "Balance must be at least 100") // Uncomment if validation is required
	    private double balance;

	    @Column(name = "first_name")
	    private String firstName;

	    @Column(name = "last_name")
	    private String lastName;

	    @Column(name = "email")
	    private String email;

	    @Column(name = "city")
	    private String city;

	    @Column(name = "state")
	    private String state;

	    @Column(name = "zip")
	    private String zip;

	    // Default constructor
	    public AccountDTO() {}

	    // Parameterized constructor
	    public AccountDTO(Integer id, String username, double balance, String firstName, String lastName, String email, String city, String state, String zip) {
	        this.id = id;
	        this.username = username;
	        this.balance = balance;
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.email = email;
	        this.city = city;
	        this.state = state;
	        this.zip = zip;
	    }
	   

	    // Getters and Setters
	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public double getBalance() {
	        return balance;
	    }

	    public void setBalance(double balance) {
	        this.balance = balance;
	    }

	    public String getFirstName() {
	        return firstName;
	    }

	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getCity() {
	        return city;
	    }

	    public void setCity(String city) {
	        this.city = city;
	    }

	    public String getState() {
	        return state;
	    }

	    public void setState(String state) {
	        this.state = state;
	    }

	    public String getZip() {
	        return zip;
	    }

	    public void setZip(String zip) {
	        this.zip = zip;
	    }

	    @Override
	    public String toString() {
	        return "AccountDTO{" +
	                "id=" + id +
	                ", username='" + username + '\'' +
	                ", balance=" + balance +
	                ", firstName='" + firstName + '\'' +
	                ", lastName='" + lastName + '\'' +
	                ", email='" + email + '\'' +
	                ", city='" + city + '\'' +
	                ", state='" + state + '\'' +
	                ", zip='" + zip + '\'' +
	                '}';
	    }
}
