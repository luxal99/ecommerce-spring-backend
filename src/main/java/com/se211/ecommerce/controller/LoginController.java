package com.se211.ecommerce.controller;

import com.se211.ecommerce.entity.User;
import com.se211.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/checkUser")
    public ResponseEntity<User> checkUser(@RequestBody User user){
        return ResponseEntity.ok(userService.checkUser(user));
    }
}
