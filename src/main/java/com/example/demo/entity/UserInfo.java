package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Table(name = "user_info")
@Entity
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "id_number", nullable = false)
    private String idNumber;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "birthday", nullable = false)
    private String birthday;

    @Column(name = "mobile_number", nullable = false)
    private String mobileNumber;

    @Column(name = "landlineNumber", nullable = true)
    private String landlineNumber;

    @Column(name = "permanentAddress", nullable = false)
    private String permanentAddress;

    @Column(name = "mailingAddress", nullable = false)
    private String mailingAddress;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
