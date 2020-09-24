package org.com.onlinewallet.dao;

import java.math.BigInteger;

import org.com.onlinewallet.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountDao extends JpaRepository<BankAccount, Integer>{
	
}