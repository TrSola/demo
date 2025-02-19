package com.example.demo.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class AuthRegisterDto {

    @NotBlank(message = "帳號不能為空")
    @Email(message = "請輸入有效的電子郵件")
    private String account;

    @NotBlank(message = "密碼不能為空")
    @Size(min = 8, message = "密碼長度至少 8 位")
    private String password;

    @NotBlank(message = "確認密碼不能為空")
    private String confirmPassword;

    @NotBlank(message = "身分證字號不能為空")
    @Pattern(regexp = "^[A-Z][12]\\d{8}$", message = "請輸入有效的身分證字號")
    private String idNumber;

    @NotBlank(message = "性別不能為空")
    @Pattern(regexp = "^(male|female)$", message = "性別只能是 male 或 female")
    private String gender;

    @NotBlank(message = "姓名不能為空")
    @Size(min = 2, message = "姓名長度至少 2 位")
    private String name;

    @NotBlank(message = "生日不能為空")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "生日格式必須為 YYYY-MM-DD")
    private String birthday;

    @NotBlank(message = "手機號碼不能為空")
    @Pattern(regexp = "^09\\d{8}$", message = "請輸入有效的手機號碼")
    private String mobileNumber;

    private String landlineNumber;

    @NotBlank(message = "戶籍地址不能為空")
    private String permanentAddress;

    @NotBlank(message = "通訊地址不能為空")
    private String mailingAddress;

    private String accountStatus;

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
