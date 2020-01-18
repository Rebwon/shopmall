package ko.maeng.shoppingmall.web.controller.account;

import ko.maeng.shoppingmall.model.account.dto.AccountResponseDto;
import ko.maeng.shoppingmall.model.account.dto.AccountSaveDto;
import ko.maeng.shoppingmall.model.account.dto.AccountUpdateDto;
import ko.maeng.shoppingmall.model.account.service.AccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @PostMapping("")
    public Long create(@RequestBody AccountSaveDto dto) {
        return accountService.save(dto);
    }

    @PutMapping("/{id}")
    public Long update(@PathVariable Long id, @RequestBody AccountUpdateDto dto){
        return accountService.update(id, dto);
    }

    @GetMapping("/{id}")
    public AccountResponseDto findById(@PathVariable Long id) {
        return accountService.findById(id);
    }
}
