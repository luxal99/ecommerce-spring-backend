package com.se211.ecommerce.repository;

import com.se211.ecommerce.entity.Client;
import com.se211.ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
