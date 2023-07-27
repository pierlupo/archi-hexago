package com.example.adapter.service;


import com.example.adapter.dto.LoginRequestDTO;
import com.example.adapter.dto.RegisterRequestDTO;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    String register(RegisterRequestDTO registerRequestDTO);

    String login(LoginRequestDTO loginRequestDTO);
}
