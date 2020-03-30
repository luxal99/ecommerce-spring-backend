package com.se211.ecommerce.service;

import com.se211.ecommerce.entity.ClientAddress;

import java.util.List;

public interface ClientAddressService {

    //region -- CRUD --
    //CRUD operation
    public List<ClientAddress> getAll();

    public ClientAddress save(ClientAddress clientAddress);

    public String update(ClientAddress clientAddress);

    public String delete(Integer id);

    //endregion
}
