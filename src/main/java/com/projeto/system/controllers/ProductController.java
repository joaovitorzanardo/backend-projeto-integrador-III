package com.projeto.system.controllers;

import com.projeto.system.dto.ProductDTO;
import com.projeto.system.entities.Product;
import com.projeto.system.services.product.ProductServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "product")
public class ProductController {

    @Autowired
    ProductServiceImpl productService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Product> saveProduct(@Valid @RequestBody ProductDTO productDTO) {
        Product newProduct = productService.saveProduct(productDTO);
        return new ResponseEntity<Product>(newProduct, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

}
