package com.daelim.petmeeting.user.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequestDTO {
    private String userId;
    private String password;
}
