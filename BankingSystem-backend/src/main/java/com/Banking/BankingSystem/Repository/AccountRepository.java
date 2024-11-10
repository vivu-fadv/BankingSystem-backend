package com.Banking.BankingSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Banking.BankingSystem.Model.Account;


@org.springframework.stereotype.Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

}
