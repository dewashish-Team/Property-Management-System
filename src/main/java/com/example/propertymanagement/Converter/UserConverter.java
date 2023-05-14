package com.example.propertymanagement.Converter;

import com.example.propertymanagement.Dto.UserDto;
import com.example.propertymanagement.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserEntity convertDtoToEntity(UserDto userDto)
    {
        UserEntity userEntity=new UserEntity();
        userEntity.setOwnerName(userDto.getOwnerName());
        userEntity.setOwnerEmail(userDto.getOwnerEmail());
        userEntity.setMobileNo(userDto.getMobileNo());
        userEntity.setPassword(userDto.getPassword());
        return userEntity;
    }
    public UserDto convertEntityToDto(UserEntity userEntity)
    {
        UserDto userDto=new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setOwnerName(userEntity.getOwnerName());
        userDto.setMobileNo(userEntity.getMobileNo());
        userDto.setOwnerEmail(userEntity.getOwnerEmail());
        return  userDto;
    }
}
