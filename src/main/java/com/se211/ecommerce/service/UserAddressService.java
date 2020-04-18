package com.se211.ecommerce.service;

import com.se211.ecommerce.entity.UserAddress;

import java.util.List;

public interface UserAddressService {

    //region -- CRUD --
    //CRUD operation
    public List<UserAddress> getAll();

    public UserAddress save(UserAddress clientAddress);

    public String update(UserAddress clientAddress);

    public String delete(Integer id);

    //endregion
}
