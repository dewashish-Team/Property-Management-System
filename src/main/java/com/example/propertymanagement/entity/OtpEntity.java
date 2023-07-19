package com.example.propertymanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "otpTable")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OtpEntity {

    /*
       id
       email
       otp
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;

    private String otp;

    private Long otpGeneratedTime;
}
