package com.example.demo.service;

import com.example.demo.dto.userInfo.UserInfoGetDto;
import com.example.demo.dto.userInfo.UserInfoUpdateDto;
import com.example.demo.entity.UserInfo;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    ResponseEntity<UserInfoGetDto> getUserInfo(HttpSession session);

    ResponseEntity<List<UserInfo>> getUserInfos(HttpSession session);

    ResponseEntity<UserInfoUpdateDto> updateUserInfo(HttpSession session,
                                                     UserInfoUpdateDto userInfoUpdateDto);

//    ResponseEntity<String> addUserInfo(UserInfoCreateDto userInfoCreateDto, Long userId);
}
