package ko.maeng.shoppingmall.model.account.service;

import ko.maeng.shoppingmall.model.account.dto.AccountDto;
import ko.maeng.shoppingmall.model.account.repository.AccountRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AccountService {

    private final AccountRepository repository;

    public AccountService(AccountRepository repository){
        this.repository = repository;
    }

    @Transactional
    public Long save(AccountDto dto) {
        return repository.save(dto.toEntity()).getId();
    }
}
