package com.projeto.system.controllers;

import com.projeto.system.dto.ProductDTO;
import com.projeto.system.entities.Product;
import com.projeto.system.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "product")
public class ProductController {

    @Autowired
    ProductService productService;

    @CrossOrigin
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public String saveProduct(@Valid @RequestBody ProductDTO productDTO) {
        productService.saveProduct(productDTO);
        return "Produto Cadastrado com Sucesso!";
    }

    @CrossOrigin
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public String updateProduct(@Valid @RequestBody ProductDTO productDTO, @RequestParam Long productId) {
        productService.updateProduct(productDTO, productId);
        return "Produto Atualizado!";
    }

    @CrossOrigin
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public String deleteProduct(@RequestParam Long productId) throws Exception {
        productService.deleteProduct(productId);
        return "Produto Excluído!";
    }

    @CrossOrigin
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @CrossOrigin
    @GetMapping(params = "clientId")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllProductsByClient(@RequestParam Long clientId) {
        return productService.getAllProductsByClient(clientId);
    }

    @CrossOrigin
    @GetMapping(params = "productId")
    @ResponseStatus(HttpStatus.OK)
    public Product getProductByProductId(@RequestParam Long productId) {
        return productService.getProductByProductId(productId);
    }



}
