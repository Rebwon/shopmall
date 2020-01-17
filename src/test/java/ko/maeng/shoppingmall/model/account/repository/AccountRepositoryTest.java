package ko.maeng.shoppingmall.model.account.repository;

import ko.maeng.shoppingmall.model.account.domain.Account;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@EnableJpaAuditing
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Before
    public void setUp(){
        Account account1 = Account.builder()
                .email("msolo021015@gmail.com")
                .username("rebwon")
                .password("123456")
                .address1("서울시 강남구 서초동")
                .address2("메르세데스 타워 1층")
                .zipCode("443-01")
                .build();

        Account account2 = Account.builder()
                .email("helloKitty@gmail.com")
                .username("kitty")
                .password("123456")
                .address1("서울시 마포구 대장동")
                .address2("바쁜 시장통")
                .zipCode("133-07")
                .build();

        Account account3 = Account.builder()
                .email("stevek@gmail.com")
                .username("kevin")
                .password("123456")
                .address1("경기도 고양시 덕양구")
                .address2("화중로 137번길")
                .zipCode("440-02")
                .build();

        List<Account> accounts = Arrays.asList(account1, account2, account3);
        accountRepository.saveAll(accounts);
    }

    @Test
    public void accountSaveChecked(){
        Account account1 = accountRepository.findById(1l).get();
        assertThat(account1.getEmail()).isEqualTo("msolo021015@gmail.com");
        assertThat(account1.getCreateAt()).isNotNull();

        Account account2 = accountRepository.findById(2l).get();
        assertThat(account2.getEmail()).isEqualTo("helloKitty@gmail.com");
        assertThat(account2.getCreateAt()).isNotNull();

        Account account3 = accountRepository.findById(3l).get();
        assertThat(account3.getEmail()).isEqualTo("stevek@gmail.com");
        assertThat(account3.getCreateAt()).isNotNull();
    }

    @Test
    public void accountSearch(){
        List<Account> accounts = accountRepository.findAll();
        assertThat(accounts).hasSize(3);
    }

    @Test
    public void deleteAll(){
        accountRepository.deleteAll();

        List<Account> accountList = accountRepository.findAll();
        assertThat(accountList).isEmpty();
    }
}