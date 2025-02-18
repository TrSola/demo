package com.example.demo.service;

import com.example.demo.dto.auth.AuthLoginDto;
import com.example.demo.dto.auth.AuthRegisterDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;

public interface AuthService {

    ResponseEntity<String> register(AuthRegisterDto authRegisterDto);

    ResponseEntity<String> login(AuthLoginDto authLoginDto, HttpSession session);

}
