package com.rebwon.shop.modules.account.service;

import com.rebwon.shop.modules.account.domain.Account;
import com.rebwon.shop.modules.account.ui.controller.request.AccountSaveDto;
import com.rebwon.shop.modules.account.ui.controller.request.AccountUpdateDto;
import com.rebwon.shop.modules.account.exception.AccountNotFoundException;
import com.rebwon.shop.modules.account.ui.controller.request.AccountResponseDto;
import com.rebwon.shop.modules.account.domain.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Long save(AccountSaveDto dto) {
        return repository.save(dto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, AccountUpdateDto dto) {
        Account account = repository.findById(id).orElseThrow(() ->
                new AccountNotFoundException("해당 사용자가 없습니다. id=" + id));

        account.updateMyAccount(dto);

        return id;
    }

    @Transactional
    public AccountResponseDto findById(Long id) {
        Account entity = repository.findById(id).orElseThrow(() ->
                new AccountNotFoundException("해당 사용자가 없습니다. id=" + id));
        return new AccountResponseDto(entity);
    }
}
