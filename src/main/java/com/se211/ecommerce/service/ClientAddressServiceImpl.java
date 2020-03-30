package com.se211.ecommerce.service;

import com.se211.ecommerce.entity.ClientAddress;
import com.se211.ecommerce.repository.ClientAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientAddressServiceImpl implements ClientAddressService{

    @Autowired
    private ClientAddressRepository clientAddressRepository;

    @Override
    public List<ClientAddress> getAll() {
        return clientAddressRepository.findAll();
    }

    @Override
    public ClientAddress save(ClientAddress clientAddress) {
        return clientAddressRepository.save(clientAddress);
    }

    @Override
    public String update(ClientAddress clientAddress) {
        clientAddressRepository.save(clientAddress);
        return "Updated";
    }

    @Override
    public String delete(Integer id) {
        clientAddressRepository.deleteById(id);
        return "Delted";
    }
}
