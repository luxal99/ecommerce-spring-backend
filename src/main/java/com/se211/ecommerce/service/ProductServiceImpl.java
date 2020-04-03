package com.se211.ecommerce.service;

import com.se211.ecommerce.entity.Product;
import com.se211.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {

        return productRepository.save(product);
    }

    @Override
    public String update(Product product) {
        productRepository.save(product);
        return "Updated";
    }

    @Override
    public String delete(Integer id) {
        productRepository.deleteById(id);
        return "Deleted";
    }
}
