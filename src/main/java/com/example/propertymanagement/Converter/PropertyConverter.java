package com.example.propertymanagement.Converter;

import com.example.propertymanagement.Dto.PropertyDto;
import com.example.propertymanagement.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component            // why we are adding? -> watch into lecture 23 notes. to reduce the line of coide from business layer
public class PropertyConverter {
    public PropertyEntity converterDtoToEntity(PropertyDto propertyDto)
    {
        PropertyEntity pe =new PropertyEntity();
        pe.setTitle(propertyDto.getTitle());
        pe.setAddress(propertyDto.getAddress());
        pe.setOwnerEmail(propertyDto.getOwnerEmail());
        pe.setOwnerName(propertyDto.getOwnerName());
        pe.setDescription(propertyDto.getDescription());
        pe.setPrice(propertyDto.getPrice());
        return pe;
    }

    public PropertyDto convertEntityToDto(PropertyEntity propertyEntity)         // DTo and Entity class help us to make loosely coupled as Dto not accessing database directly so it is good in term of security.
    {
        PropertyDto propertyDto=new PropertyDto();
        propertyDto.setId(propertyEntity.getId());
        propertyDto.setTitle(propertyEntity.getTitle());
        propertyDto.setOwnerName(propertyEntity.getOwnerName());
        propertyDto.setDescription(propertyEntity.getDescription());
        return propertyDto;
    }
}
