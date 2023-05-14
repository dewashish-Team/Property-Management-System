package com.example.propertymanagement.Dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PropertyDto {

    private Long id;
    private String title;  // will keep 1BHK , 2BHk or else
    private String description;  // description of the property
//    private String ownerName; // name of the owner
//    private String ownerEmail; // email of the owner
    private Double price;  // price of the property
    private String address; // address of the property

    @Override
    public String toString()
    {
        return this.title+" "+this.description+" ";
    }

//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getOwnerName() {
//        return ownerName;
//    }
//
//    public void setOwnerName(String ownerName) {
//        this.ownerName = ownerName;
//    }
//
//    public String getOwnerEmail() {
//        return ownerEmail;
//    }
//
//    public void setOwnerEmail(String ownerEmail) {
//        this.ownerEmail = ownerEmail;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
}
