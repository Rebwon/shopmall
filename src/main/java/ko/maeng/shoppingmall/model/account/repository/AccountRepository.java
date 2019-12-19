package ko.maeng.shoppingmall.model.account.repository;

import ko.maeng.shoppingmall.model.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
