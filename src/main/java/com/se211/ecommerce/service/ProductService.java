package com.se211.ecommerce.service;

import com.se211.ecommerce.entity.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getAll();
    public Product save(Product product);
    public String update(Product product);
    public String delete(Integer id);
}
