package com.projeto.system.services.product;

import com.projeto.system.dto.ProductDTO;
import com.projeto.system.entities.Client;
import com.projeto.system.entities.Product;
import com.projeto.system.entities.ProductType;
import com.projeto.system.repositories.ClientRepository;
import com.projeto.system.repositories.ProductRepository;
import com.projeto.system.repositories.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ProductTypeRepository productTypeRepository;

    @Autowired
    ProductRepository productRepository;

    public Product saveProduct(ProductDTO productDTO) {
        Client client = clientRepository.findClientByClientId(productDTO.getClientId());
        ProductType productType = productTypeRepository.findProductTypeByProductTypeId(productDTO.getProductTypeId());
        if (client == null){
            throw new RuntimeException("Cliente não Encontrado!");
        }
        if (productType == null){
            throw new RuntimeException("Tipo de Produto não Encontrado!");
        }
        Product product = Product.builder()
                .client(client)
                .productType(productType)
                .build();
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
