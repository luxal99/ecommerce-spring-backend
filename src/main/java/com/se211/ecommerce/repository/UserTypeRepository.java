package com.se211.ecommerce.repository;

import com.se211.ecommerce.entity.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTypeRepository extends JpaRepository<UserType,Integer> {
}
