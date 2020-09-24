package org.com.onlinewallet.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class WalletAccount {
	
	@Id
	@Column(length=5,name="AccountId")
	private int accountId;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "Status")
	Status status;

	
	@Column(name="AccountBalance")
	private double accountBalance;
	

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	

	

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "UserId")
	@JsonBackReference
	private WalletUser walletUser;

	@OneToOne(cascade = CascadeType.ALL,mappedBy="walletAccount")
	@JoinColumn(name = "AccountNo")
	@JsonManagedReference
	private BankAccount bankAccount;





	public WalletAccount(int accountId, Status status, double accountBalance, WalletUser walletUser,
			BankAccount bankAccount) {
		super();
		this.accountId = accountId;
		this.status = status;
		this.accountBalance = accountBalance;
		this.walletUser = walletUser;
		this.bankAccount = bankAccount;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public WalletUser getWalletUser() {
		return walletUser;
	}

	public void setWalletUser(WalletUser walletUser) {
		this.walletUser = walletUser;
	}

	public WalletAccount() {
		
	}
	
	
}
