package com.daelim.petmeeting.user.controller;

import com.daelim.petmeeting.user.dto.LoginRequestDTO;
import com.daelim.petmeeting.user.dto.ResponseDTO;
import com.daelim.petmeeting.user.dto.TokenInfo;
import com.daelim.petmeeting.user.dto.UserDTO;
import com.daelim.petmeeting.user.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;

@Log4j2
@Controller
@RequestMapping("/auth/")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody UserDTO dto) {
        try {
            //  서비스를 이용해 리포지터리에 유저 저장
            String userId  = userService.create(dto);
            ResponseDTO<?> responseDTO = ResponseDTO.<String>builder().data(Collections.singletonList(userId)).build();
            return ResponseEntity.ok().body(responseDTO);

        } catch(Exception e) {
            // 유저 정보는 항상 하나이므로 리스트로 만들어야 하는 ReponseDTO 를 사용하지 않고 UserDTO 를 리턴
            ResponseDTO<?> responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<ResponseDTO> signIn(@RequestBody LoginRequestDTO userLoginRequestDTO) {
        try {
            String userId = userLoginRequestDTO.getUserId();
            String password = userLoginRequestDTO.getPassword();
            ResponseDTO responseDTO = ResponseDTO.<TokenInfo>builder().data(Collections.singletonList(userService.login(userId, password))).build();
            return ResponseEntity.ok().body(responseDTO);

        } catch(Exception e) {
            // 유저 정보는 항상 하나이므로 리스트로 만들어야 하는 ReponseDTO 를 사용하지 않고 UserDTO 를 리턴
            ResponseDTO<?> responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }
}
