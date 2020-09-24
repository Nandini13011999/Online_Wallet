package org.com.onlinewallet.entities;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name="WalletTransaction")
@Table
public class WalletTransaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length=5, name="transactionId")
	int transactionId;
	
	@Column(name = "description")
	String description;
	

	@Column(name = "dateOfTransaction")
	LocalDateTime dateOfTransaction;
	

	@Column(name = "amount")
	double amount;
	
	@Column(name = "receiverAccountId")
	int receiverAccountId;
	
	@Column(name = "accountId")
	int accountId;
	
	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public WalletTransaction() {
	}

	public int getReceiverAccountId() {
		return receiverAccountId;
	}

	public void setReceiverAccountId(int receiverAccountId) {
		this.receiverAccountId = receiverAccountId;
	}

	public WalletTransaction(int transactionId, String description, LocalDateTime dateOfTransaction,
			 double amount, int receiverAccountId, int accountId, double accountBalance) {
		super();
		this.transactionId = transactionId;
		this.description = description;
		this.dateOfTransaction = dateOfTransaction;
		this.amount = amount;
		this.receiverAccountId = receiverAccountId;
		this.accountId = accountId;
		this.accountBalance = accountBalance;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getDateOfTransaction() {
		return dateOfTransaction;
	}

	public void setDateOfTransaction(LocalDateTime dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	@Column(name = "accountBalance")
	double accountBalance;
}
