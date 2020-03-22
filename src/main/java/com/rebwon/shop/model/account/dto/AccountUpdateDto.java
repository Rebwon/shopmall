package com.rebwon.shop.model.account.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountUpdateDto {
    private String password;
    private String address1;
    private String address2;
    private String zipCode;

    @Builder
    public AccountUpdateDto(String password, String address1, String address2, String zipCode) {
        this.password = password;
        this.address1 = address1;
        this.address2 = address2;
        this.zipCode = zipCode;
    }
}
