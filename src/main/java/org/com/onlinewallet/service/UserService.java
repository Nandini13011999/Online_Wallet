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

@Service
public class UserService{

	@Autowired
		UserDao userDao;
	

	
	//register new user	
	public WalletUser addUser(WalletUser user) {
		Optional<WalletUser> findById= userDao.findById(user.getUserId());
		
		if(!findById.isPresent()) {
			WalletUser newUser=userDao.save(user);
			
			return newUser;
		}
		return null;
	}
	
	//returns user by Id
		public WalletUser showUserById(int userId) {

			Optional<WalletUser> findById = userDao.findById(userId);
			if (findById.isPresent()) {
				WalletUser user = findById.get();
				return user;
			}
			return null;

		}
			
		
		// update data of user
		public String updateUser(int userId, WalletUser walletUser) {

			Optional<WalletUser> findById = userDao.findById(userId);
			if (findById.isPresent()) {
				WalletUser user = findById.get();
				user.setUserName(walletUser.getUserName());
				user.setPassword(walletUser.getPassword());
				user.setPhoneNumber(walletUser.getPhoneNumber());
				userDao.save(walletUser);
				return "User Updated";
			}
			else {
			throw new EntityNotFoundException("Question Not Found for Id" + userId);
		}
			
		}

		


	
		//authenticate user to login by using name and password
		
		public Integer checkUserLogin(String loginName,String password) 
		{
		Optional<Integer> findById=userDao.checkUserLogin(loginName,password);
		if(findById.isPresent()) 
		{
			Integer id=findById.get();
				return id;
		}
		else 
			return null;
		}
}
