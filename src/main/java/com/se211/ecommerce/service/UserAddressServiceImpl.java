package com.se211.ecommerce.service;

import com.se211.ecommerce.entity.UserAddress;
import com.se211.ecommerce.repository.UserAddressRepostirory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAddressServiceImpl implements UserAddressService {

    @Autowired
    private UserAddressRepostirory userAddressRepostirory;

    @Override
    public List<UserAddress> getAll() {
        return userAddressRepostirory.findAll();
    }

    @Override
    public UserAddress save(UserAddress clientAddress) {
        return userAddressRepostirory.save(clientAddress);
    }

    @Override
    public String update(UserAddress clientAddress) {
        userAddressRepostirory.save(clientAddress);
        return "Updated";
    }

    @Override
    public String delete(Integer id) {
        userAddressRepostirory.deleteById(id);
        return "Delted";
    }
}
