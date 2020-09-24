package org.com.onlinewallet.controller;

import org.com.onlinewallet.entities.BankAccount;
import org.com.onlinewallet.entities.Status;
import org.com.onlinewallet.entities.WalletAccount;
import org.com.onlinewallet.entities.WalletUser;
import org.com.onlinewallet.exception.*;
import org.com.onlinewallet.service.BankAccountService;
import org.com.onlinewallet.service.WalletAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/BankAccount")
public class BankAccountController {
	
	@Autowired 
	BankAccountService bankAccountService;
	
	@Autowired
	WalletAccountService walletService;
	
	
	@PostMapping("/addAccount/{walletId}")
	public ResponseEntity<Integer> addBankAccount(@PathVariable int walletId,@RequestBody BankAccount bankAccount) {
		
		BankAccount bank=new BankAccount();
		
		WalletAccount account = new WalletAccount();
		
		
		
		try {
			account=walletService.showAccountById(walletId);
			
			bankAccount.setWalletAccount(account);
			
		bank = bankAccountService.addBankAccount(bankAccount);
		
		//System.out.println(bank);
		}catch (Exception ex) {
			return new ResponseEntity<Integer>(0, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Integer>(bank.getAccountNo(), HttpStatus.CREATED);

	}
//	public boolean addAccount(@PathVariable("id") int walletId,@RequestBody BankAccount bank) 
//	{
//		boolean flag = false;
//		try {
//			BankAccount bankAccount=new BankAccount();
//			
//			WalletAccount user=new WalletAccount();
//			
//			
//			user=walletService.showAccountById(walletId);
//			System.out.println("id "+walletId);
//			bankAccount.setWalletAccount(user);
//			
//			System.out.println(user);
//			
//			flag = bankAccountService.addBankAccount(bank);
//		}
//		catch(Exception ex) {
//			ex.printStackTrace();
//		}
//		return flag;
//	}
//	
//	@GetMapping("/seeAccount/{id}")
//	@ExceptionHandler(RecordNotFoundException.class)
//	public BankAccount showAccountById(@PathVariable("id") int userId) {
//		BankAccount user = new BankAccount();
//
//		try {
//			
//			user = walletService.showAccountById(userId);
//
//			if (user == null)
//				throw new RecordNotFoundException("Record Not Found");
//
//		} catch (Exception e) {
//
//			//LOGGER.info(e.getMessage(), HttpStatus.NOT_FOUND);
//
//		}
//		return user;
//	}
	
	@GetMapping("/check/{walletAccountId}")
	public boolean checkAccount(@PathVariable int walletAccountId) 
	{
		boolean flag = false;
		try {
			flag = walletService.findBankToWallet(walletAccountId);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}

}
