package com.example.demo.dto.userInfo;

public class UserInfoUpdateDto extends UserInfoBaseDto{
    private Long id;

    public UserInfoUpdateDto() {
    }

    public UserInfoUpdateDto(String idNumber, String gender, String name, String birthday, String mobileNumber, String landlineNumber, String permanentAddress, String mailingAddress, Long id) {
        super(idNumber, gender, name, birthday, mobileNumber, landlineNumber, permanentAddress, mailingAddress);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
