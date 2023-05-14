package com.example.propertymanagement.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)     // used to return only not null value. think if there are large number of
@JsonIgnoreProperties(ignoreUnknown = true)          // not null exist then it will increase our big array.
public class UserDto {
    private Long id;
    private String ownerName;
    private String ownerEmail;
    private String mobileNo;
    private String password;

}
