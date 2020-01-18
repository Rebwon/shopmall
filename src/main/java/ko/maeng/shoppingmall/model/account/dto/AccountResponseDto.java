package ko.maeng.shoppingmall.model.account.dto;

import ko.maeng.shoppingmall.model.account.domain.Account;
import lombok.Getter;

@Getter
public class AccountResponseDto {
    private Long id;
    private String email;
    private String username;

    public AccountResponseDto(Account entity) {
        this.id = entity.getId();
        this.email = entity.getEmail();
        this.username = entity.getUsername();
    }
}
