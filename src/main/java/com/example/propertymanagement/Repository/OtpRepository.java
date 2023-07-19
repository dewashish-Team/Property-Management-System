package com.example.propertymanagement.Repository;

import com.example.propertymanagement.entity.OtpEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OtpRepository extends CrudRepository<OtpEntity,Long> {
    Optional<OtpEntity> findByEmail(String email);
}
