package com.example.demo.controller;

import com.example.demo.dto.auth.AuthLoginDto;
import com.example.demo.dto.auth.AuthLoginResDto;
import com.example.demo.dto.auth.AuthRegisterDto;
import com.example.demo.entity.User;
import com.example.demo.exception.InvalidCredentialsException;
import com.example.demo.service.AuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/auth")
@RestController
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthRegisterDto authRegisterDto) {
        return authService.register(authRegisterDto);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthLoginDto authLoginDto,
                                                 HttpSession session) {

        try {

            return authService.login(authLoginDto, session);

        } catch (InvalidCredentialsException e) {

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("帳號或密碼錯誤");

        }
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpSession session) {
        // 清除 session
        session.invalidate();
        return ResponseEntity.ok().build(); // 返回登出成功
    }


}
