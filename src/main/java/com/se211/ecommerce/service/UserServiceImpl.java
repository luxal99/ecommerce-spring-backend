package com.se211.ecommerce.service;

import com.se211.ecommerce.entity.User;
import com.se211.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public String update(User user) {
        userRepository.save(user);
        return "Updated";
    }

    @Override
    public String delete(Integer id) {
        userRepository.deleteById(id);
        return "Updated";
    }
}
