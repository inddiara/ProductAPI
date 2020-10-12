package com.example.demo.resources;

import com.example.demo.domain.Product;
import com.example.demo.dto.ProductCreateDTO;
import com.example.demo.dto.ProductNameDTO;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        List<Product> products = productService.getAll();

        return ResponseEntity.ok().body(products);
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductCreateDTO productCreateDTO){
        Product product = productService.create(productCreateDTO);

        return ResponseEntity.status(201).body(product);
    }

    @PostMapping(path = "/findByName")
    public ResponseEntity<List<Product>> findByName(@RequestBody ProductNameDTO productNameDTO){
        List<Product> products = productService.findByName(productNameDTO.getName());

        return ResponseEntity.ok().body(products);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product product = productService.findById(id);

        return ResponseEntity.ok().body(product);
    }
}

