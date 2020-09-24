package org.com.onlinewallet.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WalletAdmin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="AdminId")
	private int adminId;
	
	@Column(name="AdminName")
	private String adminName;
	
	@Column(name="AdminPassword")
	private String password;
	
	
	


	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	

	@Override
	public String toString() {
		return "WalletAdmin [adminId=" + adminId + ", adminName=" + adminName + ", password=" + password
				 + "]";
	}

	
	
	
	
	

}
