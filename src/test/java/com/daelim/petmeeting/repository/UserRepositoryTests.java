package com.daelim.petmeeting.repository;

import com.daelim.petmeeting.user.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// 모든 테스트 이상 무
@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository repository;

//    @Test
//    public void testInsert() {
//        IntStream.rangeClosed(101, 105).forEach(i -> {
//            User user = User.builder()
//                    .email("aaa@bbb.ccc "+i)
//                    .address("안양시 만안구 "+i)
//                    .userId("와꾸의 난 "+ i)
//                    .name("inho "+ i)
//                    .password("비밀번호486 "+ i)
//                    .enable(true)
//                    .build();
//            repository.save(user);
//
//        });
//    }
}
