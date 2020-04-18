package com.se211.ecommerce.service;

import com.se211.ecommerce.dto.UserDTO;
import com.se211.ecommerce.entity.User;

import java.util.List;

public interface UserService {

    public List<User> getAll();
    public UserDTO save(User user);
    public String update(User user);
    public String delete(Integer id);
    public User checkUser(User user);
}
