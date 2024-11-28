package com.Banking.BankingSystem.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Banking.BankingSystem.Model.Account;


@org.springframework.stereotype.Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	@Query("SELECT u FROM Account u WHERE u.username = :username AND u.password = :password")
	List<Account> findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}