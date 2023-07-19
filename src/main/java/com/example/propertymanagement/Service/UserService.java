package com.example.propertymanagement.Service;

import com.example.propertymanagement.Dto.OtpDto;
import com.example.propertymanagement.Dto.UserDto;
import com.example.propertymanagement.Exception.BusinessException;

public interface UserService {
    UserDto register(UserDto userDto);
    UserDto logIn(String email,String password) throws BusinessException;

    UserDto passwordResetOtpGeneration(String email); // verify the existance of email in user table before generating otp

    String passwordResetOtpVerification(OtpDto otpDto);  // verify the otp with stored in the otp table




}
