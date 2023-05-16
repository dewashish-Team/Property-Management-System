package com.example.propertymanagement.Repository;

import com.example.propertymanagement.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface UserRepository extends CrudRepository<UserEntity,Long> {

    Optional<UserEntity> findByOwnerEmailAndPassword(String email,String password);  // find by query 
}
