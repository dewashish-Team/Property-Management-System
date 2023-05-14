package com.example.propertymanagement.Service.Impl;

import com.example.propertymanagement.Converter.PropertyConverter;
import com.example.propertymanagement.Dto.PropertyDto;
import com.example.propertymanagement.Repository.PropertyRepository;
import com.example.propertymanagement.Service.PropertyService;
import com.example.propertymanagement.entity.PropertyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Value("${pms.dummy:}")
    private String dummy;

    @Value("${spring.datasource.url:}")
    private String dburl;
    @Autowired
    private PropertyRepository propertyRepository;     // creating dependancy of repository. to use functionallity of repository layer we are creating the object of rpository layer

    @Autowired
    private PropertyConverter propertyConverter;
    @Override
    public PropertyDto saveProperty(PropertyDto propertyDto)
    {
        System.out.println(propertyDto.toString()+" "+"hello world");

        /* as this is not the best way to convert the data hence we will use converter class
        //(Adapter structural Design pattern)
        // we have to convert our Dto into entity type
//        PropertyEntity pe =new PropertyEntity();
//        pe.setTitle(propertyDto.getTitle());
//        pe.setAddress(propertyDto.getAddress());
//        pe.setOwnerEmail(propertyDto.getOwnerEmail());
//        pe.setOwnerName(propertyDto.getOwnerName());
//        pe.setDescription(propertyDto.getDescription());
//        pe.setPrice(propertyDto.getPrice());

*/
        PropertyEntity pe=propertyConverter.converterDtoToEntity(propertyDto);       // coverting to save into database



        try {
//            int a=100/0;
            pe=propertyRepository.save(pe);  // as .save function will return the same data from database with id
        }
        catch (DataIntegrityViolationException e)
        {
            System.out.println("some varibale must be unique");
        }
        catch (ArithmeticException e)
        {
            System.out.println("arithmetic exception handled");
        }
        catch (Exception e)
        {
            System.out.println("Email address is already exist :"+ e.getClass().getCanonicalName());
        }
        finally
        {
            System.out.println("finally get executed");
        }
        propertyDto=propertyConverter.convertEntityToDto(pe);             // converting to give response.
        return propertyDto;
    }

    @Override
    public List<PropertyDto> allProperties() {
        System.out.println(dummy);
        System.out.println(dburl);
        List<PropertyEntity> list =(List<PropertyEntity>)propertyRepository.findAll();  // getting using jpa specs and hibernate implemantation
        List<PropertyDto> dtoList=new ArrayList<>();
        // we need to convert the list of entity object into dto.
        for(PropertyEntity pe:list)
        {
            PropertyDto dto=propertyConverter.convertEntityToDto(pe);
            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public PropertyDto updateProperties(PropertyDto propertyDto, Long id) {
        Optional<PropertyEntity> optionalObject = propertyRepository.findById(id);  // optional store any kind of object-> if there exists an id then it wil store some value otherwise it will be empty.

        System.out.println("optional object is : " + optionalObject);
        if (optionalObject.isPresent()) {
            PropertyEntity pe = optionalObject.get();
            pe.setDescription(propertyDto.getDescription());
            pe.setTitle(propertyDto.getTitle());
//            pe.setOwnerName(propertyDto.getOwnerName());
//            pe.setOwnerEmail(propertyDto.getOwnerEmail());
            pe.setPrice(propertyDto.getPrice());
            pe.setAddress(propertyDto.getAddress());
            propertyDto = propertyConverter.convertEntityToDto(pe);
            propertyRepository.save(pe);
            return propertyDto;
        }
        return null;
    }

    @Override
    public PropertyDto updatePropertyDescription(PropertyDto propertyDto, Long id) {
        Optional<PropertyEntity> optionalObject = propertyRepository.findById(id);
        if(optionalObject.isPresent())
        {
            PropertyEntity pe = optionalObject.get();        // this will store the value of optional object into propertyEntity rrefernce
            pe.setDescription(propertyDto.getDescription());
            propertyDto= propertyConverter.convertEntityToDto(pe);
            propertyRepository.save(pe);
            return propertyDto;
        }
        return null;
    }

    @Override
    public void deleteProperty(Long id) {
        propertyRepository.deleteById(id);
    }
}
