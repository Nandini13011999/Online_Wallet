package org.com.onlinewallet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.com.onlinewallet.entities.WalletTransaction;

@Repository("walletTransactionRepository")
public interface WalletTransactionRepository extends JpaRepository<WalletTransaction, Integer>{

}
