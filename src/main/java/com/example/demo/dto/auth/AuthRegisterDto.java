package com.example.demo.dto.auth;

import jakarta.persistence.Column;

public class AuthRegisterDto {
    private String account;
    private String password;
    private String confirmPassword;
    private String accountStatus;

    //userInfo
    private String idNumber;
    private String gender;
    private String name;
    private String birthday;
    private String mobileNumber;
    private String landlineNumber;
    private String permanentAddress;
    private String mailingAddress;

    public AuthRegisterDto() {
    }

    public AuthRegisterDto(String account, String password, String confirmPassword, String accountStatus, String idNumber, String gender, String name, String birthday, String mobileNumber, String landlineNumber, String permanentAddress, String mailingAddress) {
        this.account = account;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.accountStatus = accountStatus;
        this.idNumber = idNumber;
        this.gender = gender;
        this.name = name;
        this.birthday = birthday;
        this.mobileNumber = mobileNumber;
        this.landlineNumber = landlineNumber;
        this.permanentAddress = permanentAddress;
        this.mailingAddress = mailingAddress;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getLandlineNumber() {
        return landlineNumber;
    }

    public void setLandlineNumber(String landlineNumber) {
        this.landlineNumber = landlineNumber;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }
}
