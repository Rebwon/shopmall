package ko.maeng.shoppingmall.model.account.domain;

import ko.maeng.shoppingmall.model.account.dto.AccountUpdateDto;
import ko.maeng.shoppingmall.model.common.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "account")
@Getter
public class Account extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    private String address1;
    private String address2;
    private String zipCode;

    @Builder
    public Account(String email, String username, String password, String address1, String address2, String zipCode){
        this.email = email;
        this.username = username;
        this.password = password;
        this.address1 = address1;
        this.address2 = address2;
        this.zipCode = zipCode;
    }

    public void updateMyAccount(AccountUpdateDto dto){
        this.password = dto.getPassword();
        this.address1 = dto.getAddress1();
        this.address2 = dto.getAddress2();
        this.zipCode = dto.getZipCode();
    }
}
