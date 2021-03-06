package com.rebwon.shop.modules.account.ui.controller.request;

import com.rebwon.shop.modules.account.domain.Account;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountSaveDto {
    private String email;

    @NotNull
    private String username;

    @NotNull
    private String password;
    private String address1;
    private String address2;
    private String zipCode;

    @Builder
    public AccountSaveDto(String email, String username, String password, String address1, String address2, String zipCode) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.address1 = address1;
        this.address2 = address2;
        this.zipCode = zipCode;
    }

    public Account toEntity() {
        return Account.builder()
                .email(email)
                .username(username)
                .password(password)
                .address1(address1)
                .address2(address2)
                .zipCode(zipCode)
                .build();
    }
}
