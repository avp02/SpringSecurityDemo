package com.avp.springsecuritydemo.model;

import lombok.Data;

@Data
public class AuthenticationRequestDto {

    private String email;
    private String password;
}
