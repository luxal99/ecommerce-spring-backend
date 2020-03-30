package com.se211.ecommerce.service;

import com.se211.ecommerce.entity.Client;

import java.util.List;

public interface ClientService {

    public List<Client> getAll();

    public Client save(Client client);

    public String update(Client client);

    public String delete(Integer id);

}
