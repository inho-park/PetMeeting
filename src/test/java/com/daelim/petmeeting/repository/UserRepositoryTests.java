package com.daelim.petmeeting.repository;

import com.daelim.petmeeting.user.domain.User;
import com.daelim.petmeeting.user.domain.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository repository;

    @Test
    public void testInsert() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            User user = User.builder()
                    .email("aaa@bbb.ccc "+i)
                    .address("안양시 만안구 "+i)
                    .userid("와꾸의 난 "+ i)
                    .username("inho "+ i)
                    .password("비밀번호486 "+ i)
                    .enable(true)
                    .build();
            repository.save(user);

        });
    }
}
