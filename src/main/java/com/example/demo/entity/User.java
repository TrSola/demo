package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Table(name = "user")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(length = 25, nullable = true, name = "account")
    private String account;

    @Column(length = 255, nullable = false, name = "password")
    private String password;

    @Column(length = 25, nullable = false, name = "account_status")
    private String acoountStatus;

    @JsonManagedReference("User_UserInfo")
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private UserInfo userInfo;

    public User() {
    }

    public User(String password, String account) {
        this.password = password;
        this.account = account;
    }

    public User(Long id, String account, String password, String acoountStatus, UserInfo userInfo) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.acoountStatus = acoountStatus;
        this.userInfo = userInfo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAcoountStatus() {
        return acoountStatus;
    }

    public void setAcoountStatus(String acoountStatus) {
        this.acoountStatus = acoountStatus;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", acoountStatus='" + acoountStatus + '\'' +
                '}';
    }
}
