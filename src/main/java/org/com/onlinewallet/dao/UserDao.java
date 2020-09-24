package org.com.onlinewallet.dao;

import java.util.List;
import java.util.Optional;

import org.com.onlinewallet.entities.WalletAdmin;
import org.com.onlinewallet.entities.WalletUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao  extends JpaRepository< WalletUser ,Integer> {
		
		@Query( value="select user_id from wallet_user where user_name=:userName and user_password=:password", nativeQuery=true)
		public Optional<Integer> checkUserLogin(String userName, String password);
		
		

	

	
}
