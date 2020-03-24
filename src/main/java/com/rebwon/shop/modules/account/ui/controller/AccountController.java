package com.rebwon.shop.modules.account.ui.controller;

import com.rebwon.shop.modules.account.ui.controller.request.AccountResponseDto;
import com.rebwon.shop.modules.account.ui.controller.request.AccountSaveDto;
import com.rebwon.shop.modules.account.ui.controller.request.AccountUpdateDto;
import com.rebwon.shop.modules.account.service.AccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("")
    public Long create(@RequestBody AccountSaveDto dto) {
        return accountService.save(dto);
    }

    @PutMapping("/{id}")
    public Long update(@PathVariable Long id, @RequestBody AccountUpdateDto dto) {
        return accountService.update(id, dto);
    }

    @GetMapping("/{id}")
    public AccountResponseDto findById(@PathVariable Long id) {
        return accountService.findById(id);
    }
}
