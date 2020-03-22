package com.rebwon.shop.model.account.repository;

import com.rebwon.shop.model.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
