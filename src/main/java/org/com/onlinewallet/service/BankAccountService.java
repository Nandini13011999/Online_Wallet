package org.com.onlinewallet.service;

import java.math.BigInteger;
import java.util.Optional;
import java.util.Random;

import org.com.onlinewallet.dao.BankAccountDao;
import org.com.onlinewallet.dao.WalletAccountDao;
import org.com.onlinewallet.entities.BankAccount;
import org.com.onlinewallet.entities.WalletAccount;
import org.com.onlinewallet.entities.WalletUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class BankAccountService {
	
	@Autowired
	BankAccountDao bankDao;
	
	@Autowired
	WalletAccountDao walletDao;
	
	public BankAccount addBankAccount(BankAccount bank) {
		BankAccount bankAccount=null;
		
		try {
			 Random rand = new Random(); 
		bank.setAccountNo(rand.nextInt(100000));
	
	
		
	bankAccount=bankDao.save(bank);
	
	
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return bankAccount;
	}
	
	
	
	

	public BankAccount showAccountById(int walletId) {
		WalletAccount bankId=walletDao.findById(walletId).get();
		Optional<BankAccount> findById = bankDao.findById(bankId.getAccountId());
		if (findById.isPresent()) {
			BankAccount user = findById.get();
			return user;
		}
		return null;

		
	}
	
	

}
