package com.example.propertymanagement.Controller;

import com.example.propertymanagement.Dto.PropertyDto;
import com.example.propertymanagement.Service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {

    @Value("${pms.dummy:}")
    private String dummy;

    @Value("${spring.datasource.url:}")
    private String dburl;
    @Autowired
    PropertyService propertyService;
    //a Restful api is just mapping of Url to a java class function.
    @GetMapping("/hello")
    public String sayHello()
    {
        return "hello world";
    }

    @PostMapping("/newProperty")
    public ResponseEntity<PropertyDto> addNewProperty(@RequestBody PropertyDto propertyDto)
    {
        propertyDto=propertyService.saveProperty(propertyDto);
        ResponseEntity<PropertyDto> responseEntity=new ResponseEntity<>(propertyDto, HttpStatus.CREATED);
        return responseEntity;
    }


    // get all the list of properties
    @GetMapping("/properties")
    public ResponseEntity<List<PropertyDto>> allProperties()
    {
        System.out.println(dummy);
        System.out.println(dburl);
        List<PropertyDto> list=propertyService.allProperties();
        ResponseEntity<List<PropertyDto>> response=new ResponseEntity<>(list,HttpStatus.OK);
        return response;
    }
    @PutMapping("/properties/{id}")
    public ResponseEntity<PropertyDto> updateProperties(@RequestBody PropertyDto propertyDto,@PathVariable Long id)
    {
        propertyDto=propertyService.updateProperties(propertyDto,id);
        ResponseEntity<PropertyDto> response=new ResponseEntity<>(propertyDto,HttpStatus.OK);
        return response;
    }
    @PatchMapping("/properties/update-description/{id}")
    public ResponseEntity<PropertyDto> updatePropertyDescription(@RequestBody PropertyDto propertyDto, @PathVariable Long id)
    {
        propertyDto=propertyService.updatePropertyDescription(propertyDto,id);
        ResponseEntity<PropertyDto> response=new ResponseEntity<>(propertyDto,HttpStatus.OK);
        return response;
    }
    @DeleteMapping("/properties/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Long id)
    {
        propertyService.deleteProperty(id);
        ResponseEntity<Void> response =new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        return response;
    }
}
