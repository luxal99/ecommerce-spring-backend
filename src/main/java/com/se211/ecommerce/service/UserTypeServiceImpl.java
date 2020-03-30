package com.se211.ecommerce.service;

import com.se211.ecommerce.entity.UserType;
import com.se211.ecommerce.repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTypeServiceImpl implements UserTypeService {

    @Autowired
    private UserTypeRepository userTypeRepository;

    @Override
    public List<UserType> getAll() {
        return userTypeRepository.findAll();
    }

    @Override
    public UserType save(UserType userType) {
        return userTypeRepository.save(userType);
    }

    @Override
    public String update(UserType userType) {
        userTypeRepository.save(userType);
        return "Updated";
    }

    @Override
    public String delete(Integer id) {
        userTypeRepository.deleteById(id);
        return "Deleted";
    }
}
