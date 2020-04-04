package com.se211.ecommerce.service;

import com.se211.ecommerce.entity.Client;
import com.se211.ecommerce.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public String update(Client client) {
        clientRepository.save(client);
        return "Saved";
    }

    @Override
    public String delete(Integer id) {
        clientRepository.deleteById(id);
        return "Deleted";
    }

    @Override
    public Client findClientById(Integer id) {
        return clientRepository.findById(id).get();
    }
}
