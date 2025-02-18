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


@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public ResponseEntity<String> register(AuthRegisterDto authRegisterDto) {

        if (userRepository.existsByAccount(authRegisterDto.getAccount())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Account already exists");
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encryptedPassword = passwordEncoder.encode(authRegisterDto.getPassword());
        System.out.println(encryptedPassword);

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

}
