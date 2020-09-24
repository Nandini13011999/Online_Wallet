package org.com.onlinewallet.service;

import java.util.List;

import org.com.onlinewallet.entities.WalletTransaction;

public interface WalletTransactionService {
	
	
	public void createTransaction(int senderId,WalletTransaction transaction);
	public List<WalletTransaction> getTransactionList(int accountId);



}
