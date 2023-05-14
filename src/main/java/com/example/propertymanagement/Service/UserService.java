package com.example.propertymanagement.Service;

import com.example.propertymanagement.Dto.UserDto;

public interface UserService {
    UserDto register(UserDto userDto);
    UserDto logIn(String email,String password);
}
