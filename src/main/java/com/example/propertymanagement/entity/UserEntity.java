package com.example.propertymanagement.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "User_Table")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {

    /*  id
        name
        email
        phone no
        password.
    */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @Column(name = "Name")
    private String ownerName;

    @Column(name="email",unique = true,nullable = false)
    private String ownerEmail;


    private String password;

    @Column(name = "MobileNo") // space between the string are not acceptable
    private String mobileNo;


}
