package com.example.demo.serviceImpl;

import com.example.demo.dto.auth.AuthLoginDto;
import com.example.demo.dto.auth.AuthRegisterDto;
import com.example.demo.entity.User;
import com.example.demo.entity.UserInfo;
import com.example.demo.exception.AccountDisableException;
import com.example.demo.exception.InvalidCredentialsException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    @Override
    public ResponseEntity<String> register(AuthRegisterDto authRegisterDto) {

        if (userRepository.existsByAccount(authRegisterDto.getAccount())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("帳戶已存在");
        }

        if (!authRegisterDto.getPassword().equals(authRegisterDto.getConfirmPassword())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("兩次密碼不一致");
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encryptedPassword = passwordEncoder.encode(authRegisterDto.getPassword());


        User user = new User();
        user.setAccount(authRegisterDto.getAccount());
        user.setPassword(encryptedPassword);
        user.setAcoountStatus("enable");

        UserInfo userInfo = new UserInfo();
        userInfo.setIdNumber(authRegisterDto.getIdNumber());
        userInfo.setGender(authRegisterDto.getGender());
        userInfo.setName(authRegisterDto.getName());
        userInfo.setBirthday(authRegisterDto.getBirthday());
        userInfo.setMobileNumber(authRegisterDto.getMobileNumber());
        userInfo.setLandlineNumber(authRegisterDto.getLandlineNumber());
        userInfo.setPermanentAddress(authRegisterDto.getPermanentAddress());
        userInfo.setMailingAddress(authRegisterDto.getMailingAddress());


        user.setUserInfo(userInfo);
        userInfo.setUser(user);

        userRepository.save(user);


        return ResponseEntity.ok("註冊成功");
    }


    @Transactional
    @Override
    public ResponseEntity<String> login(AuthLoginDto authLoginDto, HttpSession session) {
        User user = userRepository.findByAccount(authLoginDto.getAccount());

        if (user == null) {
            throw new InvalidCredentialsException("找不到使用者");
        }

        if (!bCryptPasswordEncoder.matches(authLoginDto.getPassword(), user.getPassword())) {
            throw new InvalidCredentialsException("帳號或密錯誤");
        }

        if (user.getAcoountStatus().equals("disable")) {
            throw new AccountDisableException("帳戶不可用");
        }

        session.setAttribute("userId", user.getId());
        session.setAttribute("user", user);
        return ResponseEntity.ok("登入成功");
    }

    @Override
    @Transactional
    public ResponseEntity<String> deleteAccount(HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");

        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("未登入，無法刪除帳號");
        }

        // 2. 查詢用戶是否存在
        Optional<User> userOpt = userRepository.findById(userId);

        if (userOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("用戶不存在");
        }

        userRepository.deleteById(userId);

        session.invalidate();

        return ResponseEntity.ok("帳號刪除成功");
    }

}
