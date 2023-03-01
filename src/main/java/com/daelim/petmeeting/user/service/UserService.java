package com.daelim.petmeeting.user.service;

import com.daelim.petmeeting.user.domain.User;
import com.daelim.petmeeting.user.domain.UserRepository;
import com.daelim.petmeeting.user.dto.TokenInfo;
import com.daelim.petmeeting.user.dto.UserDTO;
import com.daelim.petmeeting.user.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Log4j2
@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;


    public String create(final UserDTO dto)  {
        User user = User.builder()
                .userId(dto.getUserId())
                .name(dto.getName())
                .address(dto.getAddress())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .enable(true)
                .build();
        userRepository.save(user);
        log.info("create : {}", dto.getUserId());
        return dto.getUserId();
    }

    public Optional<User> retrieve (final String userId) {
        return userRepository.findByUserId(userId);
    }

    public TokenInfo login(String userId, String password){
// 1. Login ID/PW 를 기반으로 Authentication 객체 생성
        // 이때 authentication 는 인증 여부를 확인하는 authenticated 값이 false
        UsernamePasswordAuthenticationToken authenticationToken
                = new UsernamePasswordAuthenticationToken(userId, password);

        // 2. 실제 검증 (사용자 비밀번호 체크)이 이루어지는 부분
        // authenticate 매서드가 실행될 때 CustomUserDetailsService 에서 만든 loadUserByUsername 메서드가 실행
        Authentication authentication = authenticationManagerBuilder
                .getObject()
                .authenticate(authenticationToken);

        // 3. 인증 정보를 기반으로 JWT 토큰 생성
        TokenInfo tokenInfo = jwtTokenProvider.generateToken(authentication);

        return tokenInfo;
    }


}
