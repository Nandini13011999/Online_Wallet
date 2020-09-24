package org.com.onlinewallet.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.com.onlinewallet.entities.WalletTransaction;
import org.com.onlinewallet.service.WalletAccountService;
import org.com.onlinewallet.service.WalletTransactionService;
import org.com.onlinewallet.exception.LowBalanceException;

@RestController
@RequestMapping()
public class TransactionController {
	
	
	
	@Autowired
    private WalletTransactionService transactionService;
	@Autowired
    private WalletAccountService walletService;
	
	@PostMapping("/transaction/{id}")
	public String transferFund(@PathVariable("id") int senderId, @RequestBody WalletTransaction transaction){
		try {
			double availableBalance = walletService.getBalance(senderId);
			System.out.println(availableBalance);
			System.out.println(transaction.getAmount());
			if(availableBalance>=transaction.getAmount()) {
				transactionService.createTransaction(senderId,transaction);
				
				return "Transaction Created";
			}
			
			
			else {
				throw new LowBalanceException("Low Balance Exception...");
				
				
			}
		}catch (Exception ex) {
			ex.printStackTrace();
			return "Transaction Declined";
		}
		
	}
	
	
	
	//this method is used to display the list of transactions by a user
	@GetMapping("/transactionList/{accountId}")
	public List<WalletTransaction> getTransactionList(@PathVariable int accountId){
		List<WalletTransaction> list = new ArrayList<WalletTransaction>();
		try {
			list = transactionService.getTransactionList(accountId);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
}
