package com.rebwon.shop.modules.account.domain;

import com.rebwon.shop.modules.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
