package com.se211.ecommerce.controller;

import com.se211.ecommerce.entity.Client;
import com.se211.ecommerce.entity.ClientAddress;
import com.se211.ecommerce.entity.Product;
import com.se211.ecommerce.entity.User;
import com.se211.ecommerce.service.ClientAddressService;
import com.se211.ecommerce.service.ClientService;
import com.se211.ecommerce.service.ProductService;
import com.se211.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {

    //region -- Client --
    @Autowired
    private ClientService clientService;

    @GetMapping("/getClients")
    public ResponseEntity<List<Client>> getAllClients() {
        return ResponseEntity.ok(clientService.getAll());
    }

    @DeleteMapping("/deleteClient/{idClient}")
    public ResponseEntity String(@PathVariable Integer idClient) {
        return ResponseEntity.ok(clientService.delete(idClient));
    }

    //endregion

    //region -- ClientAddress --

    @Autowired
    private ClientAddressService clientAddressService;

    @GetMapping("/getClientAddress")
    public ResponseEntity<List<ClientAddress>> getAllClientAddresses() {
        return ResponseEntity.ok(clientAddressService.getAll());
    }

    @DeleteMapping("/deleteClientAddress/{idClientAddress}")
    public ResponseEntity<String> deleteClientAddress(Integer idClientAddress) {
        return ResponseEntity.ok(clientAddressService.delete(idClientAddress));
    }


    //endregion

    //region -- Product --
    @Autowired
    private ProductService productService;

    @PostMapping("/saveProduct")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.save(product));
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAll());
    }

    @PutMapping("/updateProduct")
    public ResponseEntity<String> updateProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.update(product));
    }

    //endregion

    //region -- User --

    @Autowired
    private UserService userService;

    @PutMapping("/editUser")
    public ResponseEntity<String> editUser(@RequestBody User user){
        return ResponseEntity.ok(userService.update(user));
    }

    @DeleteMapping("/deleteUser/{idUser}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer idUser){
        return ResponseEntity.ok(userService.delete(idUser));
    }

    //endregion


}
