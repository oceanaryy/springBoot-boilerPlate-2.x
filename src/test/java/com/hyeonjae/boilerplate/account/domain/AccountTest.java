package com.hyeonjae.boilerplate.account.domain;

import com.hyeonjae.boilerplate.domain.account.domain.Account;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class AccountTest {

    @Test
    void 계정_생성_테스트() {
        String email = "test@gmail.com";
        String name = "테스트계정";
        String encodedPassword = "encodedPassword";

        Account account = createAccount(email, name, encodedPassword);

        assertThat(account.getEmail()).isEqualTo(email);
        assertThat(account.getName()).isEqualTo(name);
        assertThat(account.getEncodedPassword()).isEqualTo(encodedPassword);
    }

    @Test
    void 계정_업데이트_테스트() {
        String email = "test@gmail.com";
        String name = "테스트계정";
        String encodedPassword = "encodedPassword";
        String newEmail = "newTest@gmail.com";
        String newName = "새테스트계정";

        Account account = createAccount(email, name, encodedPassword);

        account.updateMyAccount(newEmail, newName);

        assertThat(account.getEmail()).isEqualTo(newEmail);
        assertThat(account.getName()).isEqualTo(newName);

    }

    private Account createAccount(String email, String name, String encodedPassword) {
        Account account = Account.builder()
                .email(email)
                .name(name)
                .encodedPassword(encodedPassword)
                .build();
        return account;
    }


}