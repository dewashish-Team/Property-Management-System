package com.example.propertymanagement.Service;

import com.example.propertymanagement.Dto.PropertyDto;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public interface PropertyService {
    //fully abstract class called interface

    // function to save the property
    public PropertyDto saveProperty(PropertyDto propertyDto);

    //list all the properties
    List<PropertyDto> allProperties();

    //full update the entity.
    PropertyDto updateProperties(PropertyDto propertyDto,Long id);

    // partial update by column Description
    PropertyDto updatePropertyDescription(PropertyDto propertyDto,Long id);

    // delete property by id
    void deleteProperty(Long id);

}
