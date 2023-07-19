package com.example.propertymanagement.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)     // used to return only not null value. think if there are large number of
@JsonIgnoreProperties(ignoreUnknown = true)          // not null exist then it will increase our big array.
public class UserDto {
    private Long id;
    private String ownerName;
    @NotNull(message = "Email is mandatory")  // field level validation provided by hibernate
    @Size(min = 4,max = 100,message = "Email must be between 4 to 100")
    private String ownerEmail;
    private String mobileNo;
    @NotEmpty( message = "Email cannot be Empty")
    @Size(min=8,max=16, message = "please enter password between 8 to 16 character")
    private String password;

}
