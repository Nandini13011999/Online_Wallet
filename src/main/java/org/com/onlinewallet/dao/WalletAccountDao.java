package org.com.onlinewallet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.com.onlinewallet.entities.*;

@Repository
public interface WalletAccountDao extends JpaRepository<WalletAccount,Integer>{

}
