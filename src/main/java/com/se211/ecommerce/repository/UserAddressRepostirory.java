package com.se211.ecommerce.repository;

import com.se211.ecommerce.entity.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAddressRepostirory extends JpaRepository<UserAddress,Integer> {
}
