package com.example.propertymanagement.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity               //to tell to hibernate that this class is going to be intract with database
@Table(name = "Property_Table")        // provide the name of the table inside database BYDefault=class name.
//@Getter
//@Setter
//@NoArgsConstructor
public class PropertyEntity {

    /*
        id
        property title
        description
        price
        address
    */
    @Id                   // instruct jpa that this is the primary key
    @GeneratedValue(strategy = GenerationType.AUTO)     // there are 4 ways to generate the pk value. To automatic generation of  pk value. Four Value of strategy =1) IDENTITY 2) AUTO 3)SEQUENCE 4) TABLE
    private long id;

    @Column(name = "property_title",nullable = false,length = 100)       // instructing jpa for restriction like NOT null, unique, name of the column etc.
    private String title;  // will keep 1BHK , 2BHk or else

    private String description;  // description of the property

//    private String ownerName; // name of the owner
//
//    @Column(name="EMAIL",unique = true,nullable = false)
//    private String ownerEmail; // email of the owner

    private Double price;  // price of the property

    private String address; // address of the property

    public PropertyEntity() {
    }

    public PropertyEntity(long id, String title, String description, String ownerName, String ownerEmail, Double price, String address) {
        this.id = id;
        this.title = title;
        this.description = description;
//        this.ownerName = ownerName;
//        this.ownerEmail = ownerEmail;
        this.price = price;
        this.address = address;
    }

    public PropertyEntity(String title, String description, String ownerName, String ownerEmail, Double price, String address) {
        this.title = title;
        this.description = description;
//        this.ownerName = ownerName;
//        this.ownerEmail = ownerEmail;
        this.price = price;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
