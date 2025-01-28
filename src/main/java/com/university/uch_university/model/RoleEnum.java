package com.university.uch_university.model;

import org.springframework.security.core.GrantedAuthority;

public enum RoleEnum implements GrantedAuthority {
    USER, ADMIN;

    @Override
    public String getAuthority() {
        return "ROLE_" + name();
    }
}
