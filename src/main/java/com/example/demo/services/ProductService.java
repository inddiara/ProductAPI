package com.example.demo.services;

import com.example.demo.domain.Product;
import com.example.demo.dto.ProductCreateDTO;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.findAll();
    };

    public List<Product> findByName(String name){
        List<Product> products = productRepository.findByName(name);

        return products;
    }

    public Product create(ProductCreateDTO productCreateDTO){
        Product product = new Product(null, productCreateDTO.getName(), productCreateDTO.getPrice());

        return productRepository.save(product);
    }

    public Product findById(Long id){
        Product product = productRepository.findById(id).get();

        return product;
    }
}
