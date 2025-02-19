package com.example.demo.serviceImpl;

import com.example.demo.dto.userInfo.UserInfoGetDto;
import com.example.demo.dto.userInfo.UserInfoUpdateDto;
import com.example.demo.entity.User;
import com.example.demo.entity.UserInfo;
import com.example.demo.repository.UserInfoRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserInfoRepository userInfoRepository;

    //獲取單個用戶資料
    @Transactional
    @Override
    public ResponseEntity<UserInfoGetDto> getUserInfo(HttpSession session) {

        Long userId = (Long) session.getAttribute("userId");
        User sessionUser = (User) session.getAttribute("user");

        if (sessionUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        if (!sessionUser.getId().equals(userId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
           UserInfo userInfo = user.get().getUserInfo();
           User userPresent = user.get();

            UserInfoGetDto userInfoGetDto = new UserInfoGetDto();
            userInfoGetDto.setId(userPresent.getId());
            userInfoGetDto.setIdNumber(userInfo.getIdNumber());
            userInfoGetDto.setGender(userInfo.getGender());
            userInfoGetDto.setName(userInfo.getName());
            userInfoGetDto.setBirthday(userInfo.getBirthday());
            userInfoGetDto.setMobileNumber(userInfo.getMobileNumber());
            userInfoGetDto.setLandlineNumber(userInfo.getLandlineNumber());
            userInfoGetDto.setPermanentAddress(userInfo.getPermanentAddress());
            userInfoGetDto.setMailingAddress(userInfo.getMailingAddress());

            return ResponseEntity.ok(userInfoGetDto);

        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }

    //獲取多個用戶資料，僅管理者可以
    @Transactional
    @Override
    public ResponseEntity<List<UserInfo>> getUserInfos(HttpSession session) {

        Long userId = (Long) session.getAttribute("userId");
        User sessionUser = (User) session.getAttribute("user");

        if (sessionUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        if (!sessionUser.getId().equals(userId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        List<UserInfo> userInfos = userInfoRepository.findAll();
        return ResponseEntity.ok(userInfos);
    }

    @Transactional
    @Override
    public ResponseEntity<UserInfoUpdateDto> updateUserInfo(HttpSession session, @RequestBody UserInfoUpdateDto userInfoUpdateDto) {

        Long userId = (Long) session.getAttribute("userId");
        User sessionUser = (User) session.getAttribute("user");

        if (sessionUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        if (!sessionUser.getId().equals(userId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            // 取得 User 和其 UserInfo
            User existingUser = user.get();
            UserInfo userInfo = existingUser.getUserInfo();

            // 根據 DTO 更新 UserInfo 的資料
            userInfo.setMobileNumber(userInfoUpdateDto.getMobileNumber());
            userInfo.setLandlineNumber(userInfoUpdateDto.getLandlineNumber());
            userInfo.setPermanentAddress(userInfoUpdateDto.getPermanentAddress());
            userInfo.setMailingAddress(userInfoUpdateDto.getMailingAddress());

            // 儲存更新後的資料
            userInfoRepository.save(userInfo);

            return ResponseEntity.ok(userInfoUpdateDto);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }

}
