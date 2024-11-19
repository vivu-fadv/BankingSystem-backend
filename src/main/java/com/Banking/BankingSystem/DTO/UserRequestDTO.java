package com.Banking.BankingSystem.DTO;

import jakarta.persistence.Column;

public class UserRequestDTO {

	@Column(name = "username")
    private String username;

	@Column(name = "password")
    private String password;

    // Getters and Setters
	public String getUsername() {
		return username;
	}

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
