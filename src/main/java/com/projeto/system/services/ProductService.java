package com.projeto.system.services;

import com.projeto.system.dto.ProductDTO;
import com.projeto.system.entities.Client;
import com.projeto.system.entities.Product;
import com.projeto.system.entities.ProductType;
import com.projeto.system.entities.TaskItem;
import com.projeto.system.repositories.ClientRepository;
import com.projeto.system.repositories.ProductRepository;
import com.projeto.system.repositories.ProductTypeRepository;
import com.projeto.system.repositories.TaskItemRepository;
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

    @Autowired
    TaskItemRepository taskItemRepository;

    public void saveProduct(ProductDTO productDTO) {
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
        productRepository.save(product);
    }

    public void updateProduct(ProductDTO productDTO, Long productId) {
        Product product = productRepository.findProductByProductId(productId);
        Client client = clientRepository.findClientByClientId(productDTO.getClientId());
        ProductType productType = productTypeRepository.findProductTypeByProductTypeId(productDTO.getProductTypeId());
        product.setClient(client);
        product.setProductType(productType);
        productRepository.save(product);
    }

    public void deleteProduct(Long productId) throws Exception {
        Product product = productRepository.findProductByProductId(productId);
        TaskItem taskItem = taskItemRepository.findByProduct(product);
        if (taskItem != null) {
            throw new Exception("Esse produto está vinculado a uma tarefa. Não é possível fazer a exclusão!");
        }
        productRepository.delete(product);
    }

    public List<Product> getAllProductsByClient(Long clientId) {
        Client client = clientRepository.findClientByClientId(clientId);
        return productRepository.findAllByClient(client);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
