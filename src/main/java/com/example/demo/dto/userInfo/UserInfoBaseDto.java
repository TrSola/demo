package com.example.demo.dto.userInfo;

public abstract class UserInfoBaseDto {
    private Long id;
    private String idNumber;
    private String gender;
    private String name;
    private String birthday;
    private String mobileNumber;
    private String landlineNumber;
    private String permanentAddress;
    private String mailingAddress;

    public UserInfoBaseDto() {
    }

    public UserInfoBaseDto(Long id, String idNumber, String gender, String name, String birthday, String mobileNumber, String landlineNumber, String permanentAddress, String mailingAddress) {
        this.id = id;
        this.idNumber = idNumber;
        this.gender = gender;
        this.name = name;
        this.birthday = birthday;
        this.mobileNumber = mobileNumber;
        this.landlineNumber = landlineNumber;
        this.permanentAddress = permanentAddress;
        this.mailingAddress = mailingAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
