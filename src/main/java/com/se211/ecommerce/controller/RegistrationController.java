package com.se211.ecommerce.controller;

import com.se211.ecommerce.dto.UserDTO;
import com.se211.ecommerce.entity.*;
import com.se211.ecommerce.exception.DuplicateColumnException;
import com.se211.ecommerce.service.*;
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

        System.out.println(user.toString());
        try {
            User userForSave = new User();
            userForSave.setUsername(user.getUsername());
            userForSave.setPassword(user.getPassword());
            userForSave.setIdUserType(user.getIdUserType());
            UserDTO userDTO = userService.save(userForSave);

            if (userDTO.getSaved()) {
                UserAddress userAddress = saveUserAddress(user.getIdClient().getIdUserAddress());
                Client client = user.getIdClient();
                client.setIdUserAddress(userAddress);

                clientService.save(client);
                userDTO.getUser().setIdClient(client);

                userService.update(userDTO.getUser());

                return ResponseEntity.ok("Successfully registration");
            } else {
                return ResponseEntity.ok("Unuccessfully registration");
            }



        } catch (Exception e) {
            e = new DuplicateColumnException();
            return ResponseEntity.ok(e.getMessage());
        }

    }

    //endregion

    //region -- UserType --

    @Autowired
    private UserTypeService userTypeService;

    @GetMapping("/getUserType")
    public ResponseEntity<List<UserType>> getUserType() {
        return ResponseEntity.ok(userTypeService.getAll());
    }

    @Autowired
    private UserAddressService userAddressService;

    @PostMapping("/saveUserAddress")
    public UserAddress saveUserAddress(@RequestBody UserAddress userAddress) {

        return userAddressService.save(userAddress);
    }


    //endregion

}
