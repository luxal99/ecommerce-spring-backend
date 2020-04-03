package com.se211.ecommerce.controller;

import com.se211.ecommerce.entity.Company;
import com.se211.ecommerce.entity.Product;
import com.se211.ecommerce.entity.User;
import com.se211.ecommerce.service.CompanyService;
import com.se211.ecommerce.service.ProductService;
import com.se211.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/checkUser")
    public ResponseEntity<User> checkUser(@RequestBody User user){
        return ResponseEntity.ok(userService.checkUser(user));
    }

    @Autowired
    private CompanyService companyService;

    @GetMapping("/findCompany/{idCompany}")
    public ResponseEntity<Company> findCompany(@PathVariable Integer idCompany){
        System.out.println(idCompany);
        return ResponseEntity.ok(companyService.findCompanyById(idCompany));
    }

    @Autowired
    private ProductService productService;

    @GetMapping("/getProduct/{idCompany}")
    public ResponseEntity<List<Product>> getProductByCompanyId(@PathVariable Integer idCompany){
        return ResponseEntity.ok(productService.getProductByCompanyId(idCompany));
    }
}
