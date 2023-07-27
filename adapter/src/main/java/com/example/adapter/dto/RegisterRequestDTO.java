package com.example.adapter.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDTO {

    private String name;
    private String username;
    private String email;
    private String password;
}
