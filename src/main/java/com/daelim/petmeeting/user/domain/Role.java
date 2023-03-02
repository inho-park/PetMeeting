package com.daelim.petmeeting.user.domain;

public enum Role {
    ROLE_ADMIN("ROLE_ADMIN"), ROLE_MANAGER("ROLE_MANAGER"), ROLE_USER("ROLE_USER");

    private String role;

    Role(String role) { this.role = role; }
}
