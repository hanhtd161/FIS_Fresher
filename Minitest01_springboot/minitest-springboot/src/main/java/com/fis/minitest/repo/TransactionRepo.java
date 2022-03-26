package com.fis.minitest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fis.minitest.entity.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long>{

}
