package org.com.onlinewallet.service;

import java.util.List;
import java.util.Optional;

import org.com.onlinewallet.dao.*;
import org.com.onlinewallet.entities.WalletAdmin;
import org.com.onlinewallet.entities.WalletUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.com.onlinewallet.exception.*;

@Service("AdminServiceImpl")
public class AdminService{

	@Autowired
	AdminDao adminDao;
	
	//@Autowired
//	UserDao userDao;
	
	//add new admin
	
	public WalletAdmin addAdmin(WalletAdmin admin) {
		Optional<WalletAdmin> findById= adminDao.findById(admin.getAdminId());
		
		if(!findById.isPresent()) {
			WalletAdmin newAdmin=adminDao.save(admin);
			
			return newAdmin;
		}
		return null;
	}

	
	
	// update data of admin
	public WalletAdmin updateAdmin(WalletAdmin walletAdmin) {

		Optional<WalletAdmin> findById = adminDao.findById(walletAdmin.getAdminId());
		if (findById.isPresent()) {
			WalletAdmin admin = adminDao.save(walletAdmin);
			return admin;
		}
		return null;
	}
	
	
	
	//returns admin by Id
	public WalletAdmin showAdminById(int aid) {

		Optional<WalletAdmin> findById = adminDao.findById(aid);
		if (findById.isPresent()) {
			WalletAdmin admin = findById.get();
			return admin;
		}
		return null;

	}
		
		

	//show all registered users
	//public List<WalletUser> showRegisteredUsers() {
	//	return userDao.getRegisteredAccounts();
		
	//}

	// return all accepted user function
	//public List<WalletUser> showAcceptedUsers() {
	//	return userDao.getAcceptedAccounts();
//	}

	// delete admin by id
	public String removeAdminById(int adminId) {
		
		Optional<WalletAdmin> findById = adminDao.findById(adminId);
		if (findById.isPresent()) {
			adminDao.deleteById(adminId);
			return "admin removed";
		}
		return "!!   Id Is Invalid   !!";
	}

	
	
	
	
	
	
	/*****************/

//authenticate admin to login by using name and password
	public Integer checkAdminLogin(String loginName,String password) 
	{
	Optional<Integer> findById=adminDao.checkAdminLogin(loginName,password);
	if(findById.isPresent()) 
	{
		Integer id=findById.get();
			return id;
	}
	else 
		return null;
	}

	

	
	
/*	
	public int updateStatus(Enum status, int user_id) {
		Optional<WalletUser> findById = userDao.findById(user_id);
		if (findById.isPresent()) {
			return accountDao.updateStatus(user_id, status);

		}
		
		return 0;
	}
	
	
*/
}
