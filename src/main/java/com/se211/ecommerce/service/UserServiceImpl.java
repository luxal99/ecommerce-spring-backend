package com.se211.ecommerce.service;

import com.se211.ecommerce.dto.UserDTO;
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
    public UserDTO save(User user) {

        UserDTO userDTO = new UserDTO();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        try {
            userRepository.save(user);
            userDTO.setUser(user);
            userDTO.setSaved(true);
            return userDTO;
        } catch (Exception e) {
            e = new DuplicateColumnException();
            userDTO.setSaved(false);
            return userDTO;
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
