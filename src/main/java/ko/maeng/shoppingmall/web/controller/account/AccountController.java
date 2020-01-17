package ko.maeng.shoppingmall.web.controller.account;

import ko.maeng.shoppingmall.model.account.dto.AccountDto;
import ko.maeng.shoppingmall.model.account.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @PostMapping("")
    public Long create(AccountDto dto) {
        return accountService.save(dto);
    }
}
