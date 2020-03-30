package com.se211.ecommerce.repository;

import com.se211.ecommerce.entity.Client;
import com.se211.ecommerce.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Integer> {
}
