package org.com.onlinewallet.entities;

import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class BankAccount {
	
	@Id
	@Column(name = "AccountNo")
	private int accountNo;
	
	@Column(name = "HolderName")
	private String holderName;
	
	@Column(name = "IFSCCode")
	private String ifscCode;
	
	public WalletAccount getWalletAccount() {
		return walletAccount;
	}

	public void setWalletAccount(WalletAccount walletAccount) {
		this.walletAccount = walletAccount;
	}

	public BankAccount(int accountNo, String holderName, String ifscCode, String bankName,
			WalletAccount walletAccount) {
		super();
		this.accountNo = accountNo;
		this.holderName = holderName;
		this.ifscCode = ifscCode;
		this.bankName = bankName;
		this.walletAccount = walletAccount;
	}

	@Column(name = "BankName")
	private String bankName;

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int i) {
		this.accountNo = i;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public BankAccount() {
		super();
	}
	
	public BankAccount(int accountNo, String holderName, String ifscCode, String bankName) {
		super();
		this.accountNo = accountNo;
		this.holderName = holderName;
		this.ifscCode = ifscCode;
		this.bankName = bankName;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	private WalletAccount walletAccount;

	


	
	

}
