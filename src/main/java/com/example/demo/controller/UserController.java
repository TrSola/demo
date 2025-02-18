package com.example.demo.controller;

import com.example.demo.dto.userInfo.UserInfoGetDto;
import com.example.demo.dto.userInfo.UserInfoUpdateDto;
import com.example.demo.entity.UserInfo;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/userInfo")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/get")
    public ResponseEntity<UserInfoGetDto> getUserInfo(HttpSession session) {
        return userService.getUserInfo(session);
    }

    @PostMapping("/update")
    public ResponseEntity<UserInfoUpdateDto> updateUserInfo(HttpSession session,
                                                            @RequestBody UserInfoUpdateDto userInfoUpdateDto) {
        return userService.updateUserInfo(session, userInfoUpdateDto);
    }

    @PostMapping("/getAll")
    public ResponseEntity<List<UserInfo>> getUserInfos(HttpSession session) {
        return userService.getUserInfos(session);
    }

}
