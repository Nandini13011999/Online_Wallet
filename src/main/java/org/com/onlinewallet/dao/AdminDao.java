package org.com.onlinewallet.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import org.com.onlinewallet.entities.WalletAdmin;


@Repository
public interface AdminDao extends JpaRepository< WalletAdmin ,Integer> {
	
	@Query( value="select admin_id from wallet_admin where admin_name=:adminName and admin_password=:password", nativeQuery=true)
	public Optional<Integer> checkAdminLogin(String adminName, String password);
	
	

}
