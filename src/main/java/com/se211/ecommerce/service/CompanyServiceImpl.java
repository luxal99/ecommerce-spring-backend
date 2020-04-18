package com.se211.ecommerce.service;

import com.se211.ecommerce.entity.Company;
import com.se211.ecommerce.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public String update(Company company) {
        companyRepository.save(company);
        return "Updated";
    }

    @Override
    public String delete(Integer id) {
        companyRepository.deleteById(id);
        return "Deleted";
    }

    @Override
    public Company findCompanyById(Integer idCompany) {

        return companyRepository.findById(idCompany).get();
    }
}
