package ko.maeng.shoppingmall.model.account.service;

import ko.maeng.shoppingmall.model.account.domain.Account;
import ko.maeng.shoppingmall.model.account.dto.AccountResponseDto;
import ko.maeng.shoppingmall.model.account.dto.AccountUpdateDto;
import ko.maeng.shoppingmall.model.account.exception.AccountNotFoundException;
import ko.maeng.shoppingmall.model.account.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

    private final AccountRepository repository;

    public AccountService(AccountRepository repository){
        this.repository = repository;
    }

    @Transactional
    public Long save(AccountResponseDto dto) {
        return repository.save(dto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, AccountUpdateDto dto) {
        Account account = repository.findById(id).orElseThrow(() ->
                new AccountNotFoundException("해당 사용자가 없습니다. id=" + id));

        account.updateMyAccount(dto);

        return id;
    }
}
