package org.com.onlinewallet.controller;

import java.util.Random;

import org.com.onlinewallet.entities.BankAccount;
import org.com.onlinewallet.entities.Status;
import org.com.onlinewallet.entities.WalletAccount;
import org.com.onlinewallet.entities.WalletUser;
import org.com.onlinewallet.exception.*;
import org.com.onlinewallet.service.UserService;
import org.com.onlinewallet.service.WalletAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/WalletAccount")
public class WalletController{
Logger logger = LoggerFactory.getLogger(this.getClass());

@Autowired
private WalletAccountService walletAccountService;

@Autowired
private UserService walletUser;


@GetMapping(value = "/create/{userId}")
public ResponseEntity<Integer> saveWalletUser(@PathVariable int userId) {
	WalletAccount account = new WalletAccount();
	
	WalletUser user=new WalletUser();
	user=walletUser.showUserById(userId);
	Random random=new Random();
	account.setAccountId(random.nextInt(100000));

	account.setStatus(Status.ACTIVE);
	account.setAccountBalance(0);
	account.setWalletUser(user);
	try {
		
	account = walletAccountService.createWalletAccount(account);
	
	}catch (Exception ex) {
		return new ResponseEntity<Integer>(0, HttpStatus.BAD_REQUEST);
	}
	return new ResponseEntity<Integer>(account.getAccountId(), HttpStatus.CREATED);

}

@GetMapping("/seeWalletAccount/{id}")
@ExceptionHandler(EntityNotFoundException.class)
public WalletAccount showAccountById(@PathVariable("id") int walletId) {
	WalletAccount wallet = new WalletAccount();

	try {
		wallet = walletAccountService.showAccountById(walletId);

		if (wallet == null)
			throw new EntityNotFoundException("Record Not Found");

	} catch (Exception e) {

		e.printStackTrace();

	}
	return wallet;
}




@GetMapping("/addMoney/{accountId}/{amount}")
public ResponseEntity<?> addMoney(@PathVariable int accountId, @PathVariable double amount) {
	double finalBalance = 0;
	try {
		if(amount>0)
		{WalletAccount account = walletAccountService.showAccountById(accountId);
		double prevBalance = account.getAccountBalance();
		finalBalance  = prevBalance + amount;
		account.setAccountBalance(finalBalance);
		finalBalance = walletAccountService.updateBalance(account);
		return new ResponseEntity<String>("Amount Added", HttpStatus.OK);	
		}
		else {
			return new ResponseEntity<String>("Please enter valid amount, amount cannot be negative", HttpStatus.CONFLICT);
		}
		
	}
	catch(Exception ex) {
		ex.printStackTrace();
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
	}
	
}



}
