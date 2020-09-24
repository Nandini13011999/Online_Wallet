package org.com.onlinewallet.controller;

import org.com.onlinewallet.entities.WalletAdmin;
import org.com.onlinewallet.entities.WalletUser;

import org.com.onlinewallet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



import org.com.onlinewallet.exception.*;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@RestController
@RequestMapping("/User")
public class UserController {

	@Autowired
	private UserService userService;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	// add new user
	
	@PostMapping("/addUser")
	public WalletUser addUser(@RequestBody WalletUser user) {

		WalletUser addUser = new WalletUser();

		try {
			addUser = userService.addUser(user);

			if (user == null)
				throw new EntityNotFoundException("Record Not Found");

		} catch (Exception e) {

			LOGGER.info(e.getMessage(), HttpStatus.NOT_FOUND);

		}
		return addUser;

	}

	// get user By Id
		 @GetMapping("/findUserById/{id}")
		
		@ExceptionHandler(EntityNotFoundException.class)
		public WalletUser showUserById(@PathVariable("id") int userId) {
			WalletUser user = new WalletUser();

			try {
				user = userService.showUserById(userId);

				if (user == null)
					throw new EntityNotFoundException("Record Not Found");

			} catch (Exception e) {

				LOGGER.info(e.getMessage(), HttpStatus.NOT_FOUND);

			}
			return user;
		}
		 
//		 @PutMapping("/updateUser")
//			@ExceptionHandler(EntityNotFoundException.class)
//			public WalletUser updateUser(@RequestBody WalletUser walletUser) {
//				WalletUser user = new WalletUser();
//
//				try {
//					user = userService.updateUser(walletUser);
//
//					if (user == null)
//						throw new EntityNotFoundException("Record Not Found");
//
//				} catch (Exception e) {
//
//					LOGGER.info(e.getMessage(), HttpStatus.NOT_FOUND);
//
//				}
//				return user;
//			}
		 
		 @PutMapping("/updateUser/{id}")
			public ResponseEntity<?> updateUser(@PathVariable(value = "id") int userId,
					@Validated @RequestBody WalletUser walletUser) {
				try {
					userService.updateUser(userId, walletUser);
					return new ResponseEntity<String>("User updated", HttpStatus.OK);
				} catch (Exception e) {
					return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);

				}

			}

		
	
	
		
	
		 @GetMapping("/login/{loginName}/{password}")
			public String validUserLogin(@PathVariable("loginName") String loginName,@PathVariable("password") String password) {
				int x= userService.checkUserLogin(loginName,password);
				if(x==1) {
					return "login successful";
				}
				else
					return "login denied";
			}
	
}
