package org.com.onlinewallet.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class WalletUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="UserId")
	private int UserId;
	
	@Column(name="UserName")
	private String UserName;
	
	@Column(name="UserPassword")
	private String Password;
	
	@Column(name="PhoneNumber")
	private long PhoneNumber;
	
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "walletUser")
	@JsonManagedReference
	private WalletAccount walletAccount;

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	

	public long getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	

	
	@Override
	public String toString() {
		return "WalletUser [UserId=" + UserId + ", UserName=" + UserName + ", Password=" + Password + ", PhoneNumber="
				+ PhoneNumber +  ", walletAccount=" + walletAccount + "]";
	}
	
	
	

}
