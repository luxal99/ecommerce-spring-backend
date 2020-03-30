package com.se211.ecommerce.controller;

import com.se211.ecommerce.entity.User;
import com.se211.ecommerce.entity.UserType;
import com.se211.ecommerce.service.UserService;
import com.se211.ecommerce.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
@RestController("registration")
public class RegistrationController {

    //region -- User --

    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    //endregion

    //region -- UserType --

    @Autowired
    private UserTypeService userTypeService;

    @GetMapping("/getUserType")
    public ResponseEntity<List<UserType>> getUserType() {
        return ResponseEntity.ok(userTypeService.getAll());
    }


    //endregion

}
