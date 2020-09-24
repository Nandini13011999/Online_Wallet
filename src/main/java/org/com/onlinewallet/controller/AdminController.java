package org.com.onlinewallet.controller;

import org.com.onlinewallet.entities.WalletAdmin;
import org.com.onlinewallet.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.com.onlinewallet.exception.*;


@RestController
@RequestMapping("/Admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

	// add new admin
	@PostMapping("/addAdmin")
	@ExceptionHandler(EntityNotFoundException.class)
	public WalletAdmin addAdmin(@RequestBody WalletAdmin admin) {

		WalletAdmin addAdmin = new WalletAdmin();

		try {
			addAdmin = adminService.addAdmin(admin);

			if (admin == null)
				throw new EntityNotFoundException("Record Not Found");

		} catch (Exception e) {

			LOGGER.info(e.getMessage(), HttpStatus.NOT_FOUND);

		}
		return addAdmin;

	}

	
	
	// delete admin
		@DeleteMapping("/deleteAdmin/{id}")
		
		@ExceptionHandler(EntityNotFoundException.class)
		public String removeAdminById(@PathVariable("id") int aid) {
			String msg = null;

			try {
				msg = adminService.removeAdminById(aid);

				if (!msg.equals("admin removed"))
					throw new EntityNotFoundException("Record Not Found");

			} catch (Exception e) {

				LOGGER.info(e.getMessage(), HttpStatus.NOT_FOUND);

			}
			return msg;
		}
		
		
		
/*********************************************/	
		
		
	
// update admin

 @PutMapping("/updateAdmin")
	@ExceptionHandler(EntityNotFoundException.class)
	public WalletAdmin updateAdmin(@RequestBody WalletAdmin walletAdmin) {
		WalletAdmin admin = new WalletAdmin();

		try {
			admin = adminService.updateAdmin(walletAdmin);

			if (admin == null)
				throw new EntityNotFoundException("Record Not Found");

		} catch (Exception e) {

			LOGGER.info(e.getMessage(), HttpStatus.NOT_FOUND);

		}
		return admin;
	}

	
	
	// get admin By Id
	 @GetMapping("/findAdminById/{id}")
	
	@ExceptionHandler(EntityNotFoundException.class)
	public WalletAdmin showAdminById(@PathVariable("id") int aid) {
		WalletAdmin admin = new WalletAdmin();

		try {
			admin = adminService.showAdminById(aid);

			if (admin == null)
				throw new EntityNotFoundException("Record Not Found");

		} catch (Exception e) {

			LOGGER.info(e.getMessage(), HttpStatus.NOT_FOUND);

		}
		return admin;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
