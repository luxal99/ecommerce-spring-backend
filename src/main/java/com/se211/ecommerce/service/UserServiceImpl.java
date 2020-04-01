package com.se211.ecommerce.service;

import com.se211.ecommerce.entity.User;
import com.se211.ecommerce.exception.DuplicateColumnException;
import com.se211.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    public String save(User user) {
        System.out.println(user.getPassword());
        System.out.println(user);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        try {
            userRepository.save(user);
            return "Saved";
        } catch (Exception e) {
            e = new DuplicateColumnException();
            return e.getMessage();
        }

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

    @Override
    public User checkUser(User user) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        for (User userForSearch :
                getAll()) {
            if (userForSearch.getUsername().equals(user.getUsername())) {
                if (bCryptPasswordEncoder.matches(user.getPassword(), userForSearch.getPassword())) {
                    return userForSearch;
                }
            }
        }
        return null;
    }

}
