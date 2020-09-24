package org.com.onlinewallet.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.com.onlinewallet.exception.*;
import org.com.onlinewallet.entities.WalletAccount;
import org.com.onlinewallet.entities.WalletTransaction;
import org.com.onlinewallet.dao.WalletAccountDao;
import org.com.onlinewallet.dao.WalletTransactionRepository;

@Service
public class WalletTransactionServiceImpl implements WalletTransactionService{
	
	@Autowired 
	WalletTransactionRepository walletTransactionRepository;
	
	@Autowired
	WalletAccountDao walletAccountRepository;
	
	@Autowired 
	WalletAccountService walletAccountService;
	
//	 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
//	   LocalDateTime now = LocalDateTime.now();  
//	   System.out.println(dtf.format(now));  
//	
	
	
	@Override
	public void createTransaction(int senderId,WalletTransaction transaction) {
//		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   
		   WalletAccount senderAccount = new WalletAccount();
		   WalletAccount receiverAccount = new WalletAccount();
		try {
			int recipientAccountId = transaction.getReceiverAccountId();
		    double transferAmount = transaction.getAmount();
//			int senderAccountId = transaction.getAccountId();
		    
			 senderAccount = walletAccountService.showAccountById(senderId);
			 System.out.println(senderAccount);
			double senderPrevBalance = senderAccount.getAccountBalance();
			 receiverAccount = walletAccountService.showAccountById(transaction.getReceiverAccountId());
			double receiverPrevBalance = receiverAccount.getAccountBalance();
			double senderFinalBalance  = senderPrevBalance - transferAmount;
			double receiverfinalBalance = receiverPrevBalance + transferAmount;
			senderAccount.setAccountBalance(senderFinalBalance);
			receiverAccount.setAccountBalance(receiverfinalBalance);
			senderFinalBalance = walletAccountService.updateBalance(senderAccount);
			receiverfinalBalance = walletAccountService.updateBalance(receiverAccount);
			transaction.setAccountId(senderId);
	
			transaction.setDateOfTransaction(now);
			walletTransactionRepository.save(transaction);
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
 
    @Override
	public List<WalletTransaction> getTransactionList(int accountId) {
		List<WalletTransaction> list = new ArrayList<WalletTransaction>();
		try {
			List<WalletTransaction> listAll = walletTransactionRepository.findAll();
			for(WalletTransaction transaction: listAll) {
				if(transaction.getAccountId()==accountId) {
					list.add(transaction);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}