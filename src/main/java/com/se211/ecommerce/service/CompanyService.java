package com.se211.ecommerce.service;

import com.se211.ecommerce.entity.Company;

import java.util.List;

public interface CompanyService {
    public List<Company> getAll();
    public Company save(Company company);
    public String update(Company company);
    public String delete(Integer id);
    public Company findCompanyById(Integer idCompany);
}
