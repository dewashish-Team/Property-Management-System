package com.example.propertymanagement.Controller;

import com.example.propertymanagement.Dto.OtpDto;
import com.example.propertymanagement.Dto.UserDto;
import com.example.propertymanagement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController            // @ResponseBody + @Controller
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody UserDto userDto)
    {
        userDto=userService.register(userDto);
        ResponseEntity<UserDto> response=new ResponseEntity<>(userDto, HttpStatus.CREATED);
        return response;
    }
    @PostMapping("/login")
    public ResponseEntity<UserDto> logIn(@RequestBody UserDto userDto)
    {
        userDto=userService.logIn(userDto.getOwnerEmail(),userDto.getPassword());
        ResponseEntity<UserDto> response=new ResponseEntity<>(userDto,HttpStatus.OK);
        return response;
    }
    @PostMapping("/otp")
    public ResponseEntity<UserDto> passwordResetOtpGeneration(@RequestBody UserDto userDto)
    {
        userDto=userService.passwordResetOtpGeneration(userDto.getOwnerEmail());
        return new ResponseEntity<>(userDto,HttpStatus.CREATED);
    }
    @PostMapping("/verify")
    public ResponseEntity<String> passwordResetOtpVerification(@RequestBody OtpDto otpDto)
    {
        String message=userService.passwordResetOtpVerification(otpDto);
        return new ResponseEntity<>(message,HttpStatus.ACCEPTED);
    }

}
