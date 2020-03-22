package com.rebwon.shop.model.account.dto;

import com.rebwon.shop.model.account.domain.Account;
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