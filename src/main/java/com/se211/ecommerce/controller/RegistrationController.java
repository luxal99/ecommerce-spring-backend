package com.se211.ecommerce.controller;

import com.se211.ecommerce.entity.Client;
import com.se211.ecommerce.entity.Company;
import com.se211.ecommerce.entity.User;
import com.se211.ecommerce.entity.UserType;
import com.se211.ecommerce.service.ClientService;
import com.se211.ecommerce.service.CompanyService;
import com.se211.ecommerce.service.UserService;
import com.se211.ecommerce.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("registration")
public class RegistrationController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/saveClient")
    public ResponseEntity<Client> saveClient(@RequestBody Client client) {
        return ResponseEntity.ok(clientService.save(client));
    }

    @Autowired
    private CompanyService companyService;

    @PostMapping("/saveCompany")
    public ResponseEntity<Company> saveCompany(@RequestBody Company company) {
        return ResponseEntity.ok(companyService.save(company));
    }

    //region -- User --

    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<String> register(@RequestBody User user) {
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
