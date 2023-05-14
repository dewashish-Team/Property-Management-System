package com.example.propertymanagement.Controller;

import com.example.propertymanagement.Dto.UserDto;
import com.example.propertymanagement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController            // @ResponseBody + @Controller
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

}
