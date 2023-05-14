package com.example.propertymanagement.Repository;

import com.example.propertymanagement.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends CrudRepository<UserEntity,Long> {
}
