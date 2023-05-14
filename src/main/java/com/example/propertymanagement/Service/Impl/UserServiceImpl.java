package com.example.propertymanagement.Service.Impl;

import com.example.propertymanagement.Converter.UserConverter;
import com.example.propertymanagement.Dto.UserDto;
import com.example.propertymanagement.Repository.UserRepository;
import com.example.propertymanagement.Service.UserService;
import com.example.propertymanagement.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDto register(UserDto userDto) {
        // if user exist then return notice that user already exist
        UserEntity userEntity=userConverter.convertDtoToEntity(userDto);  // converting dto to entity
        userRepository.save(userEntity);             // saving the return entity into repository
        userDto=userConverter.convertEntityToDto(userEntity);
        return userDto;
    }

    @Override
    public UserDto logIn(String email, String password) {
        return null;
    }
}
