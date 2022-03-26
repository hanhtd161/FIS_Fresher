package com.fis.minitest.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fis.minitest.entity.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {
	List<Account> findByOrderByAccountNameAsc();
	Optional<Account> findByAccountNumber(String accountNumber);
}
