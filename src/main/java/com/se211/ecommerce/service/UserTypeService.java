package com.se211.ecommerce.service;

import com.se211.ecommerce.entity.User;
import com.se211.ecommerce.entity.UserType;

import java.util.List;

public interface UserTypeService {

    public List<UserType> getAll();

    public UserType save(UserType userType);

    public String update(UserType userType);

    public String delete(Integer id);

}
