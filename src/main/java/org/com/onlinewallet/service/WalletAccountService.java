package org.com.onlinewallet.service;

import java.util.Optional;

import org.com.onlinewallet.dao.BankAccountDao;
import org.com.onlinewallet.dao.WalletAccountDao;
import org.com.onlinewallet.entities.BankAccount;
import org.com.onlinewallet.entities.WalletAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WalletAccountService {
	@Autowired 
	WalletAccountDao walletAccountDao;
	
	@Autowired
	BankAccountDao bankAccountDao;

	public WalletAccount createWalletAccount(WalletAccount account) {
		WalletAccount wa = null;
		try {
			wa = walletAccountDao.save(account);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return wa;
	}
	
public WalletAccount showAccountById(int userId) {
		Optional<WalletAccount> findById = walletAccountDao.findById(userId);
	if (findById.isPresent()) {
			WalletAccount user = findById.get();
		return user;
	}
	return null;

	}

	public boolean findBankToWallet(int walletAccountId) {
		boolean flag = false;
		try {
			flag = bankAccountDao.existsById(walletAccountId);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}
	
	public double getBalance(int accountId) {
		double balance = 0;
		try {
			balance = walletAccountDao.findById(accountId).get().getAccountBalance();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return balance;
	}
	
	public double updateBalance(WalletAccount account) {
		double totalBalance = 0;
		try {
			walletAccountDao.save(account);
			totalBalance = this.getBalance(account.getAccountId());
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return totalBalance;
	}


		

		
	};

	

	

