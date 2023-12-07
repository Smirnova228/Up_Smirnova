package com.example.finalprojectapteka.models;

import org.springframework.security.core.GrantedAuthority;

public enum roleEnum implements GrantedAuthority {
    USER, ADMIN, EMPLOYEE;
    public String getAuthority()
    {
        return name();
    }
}
