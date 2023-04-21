package com.projeto.system.services.product;

import com.projeto.system.dto.ProductDTO;
import com.projeto.system.entities.Product;

import java.util.List;

public interface ProductService {

    public Product saveProduct(ProductDTO productDTO);
    public List<Product> getAllProducts();

}
