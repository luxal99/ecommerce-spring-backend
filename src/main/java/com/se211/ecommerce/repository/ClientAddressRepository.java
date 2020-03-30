package com.se211.ecommerce.repository;

import com.se211.ecommerce.entity.Client;
import com.se211.ecommerce.entity.ClientAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientAddressRepository extends JpaRepository<ClientAddress,Integer> {
}
