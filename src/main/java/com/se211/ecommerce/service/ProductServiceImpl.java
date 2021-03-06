package com.se211.ecommerce.service;

import com.se211.ecommerce.entity.Product;
import com.se211.ecommerce.exception.MaximumCharacterException;
import com.se211.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        try{
            return productRepository.save(product);
        }catch (Exception e){
            e = new MaximumCharacterException("Maximum character");
            return null;
        }

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

    @Override
    public List<Product> getProductByCompanyId(Integer idCompany) {
        List<Product> productList = new ArrayList<>();

        for (Product product:getAll()){
            if (product.getIdCompany().getIdCompany() == idCompany){
                productList.add(product);
            }
        }
        return productList;
    }
}
