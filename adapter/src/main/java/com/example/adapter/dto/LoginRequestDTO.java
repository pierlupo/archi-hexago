package com.example.adapter.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDTO {

    private String usernameOrEmail;

    private String password;
}
