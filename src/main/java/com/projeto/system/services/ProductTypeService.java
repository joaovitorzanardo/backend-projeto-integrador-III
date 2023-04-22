package com.projeto.system.services;

import com.projeto.system.dto.ProductTypeDTO;
import com.projeto.system.entities.Product;
import com.projeto.system.entities.ProductType;
import com.projeto.system.repositories.ProductRepository;
import com.projeto.system.repositories.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService {

    @Autowired
    ProductTypeRepository productTypeRepository;

    @Autowired
    ProductRepository productRepository;

    public ProductType saveProductType(ProductTypeDTO productTypeDTO) {
        ProductType productType = ProductType.builder()
                .description(productTypeDTO.getDescription())
                .build();
        return productTypeRepository.save(productType);
    }

    public void updateProductType(ProductTypeDTO productTypeDTO, Long productTypeId) {
        ProductType productType = productTypeRepository.findProductTypeByProductTypeId(productTypeId);
        productType.setDescription(productTypeDTO.getDescription());
    }

    public void deleteProductType(Long productTypeId) throws Exception {
        ProductType productType = productTypeRepository.findProductTypeByProductTypeId(productTypeId);
        Product product = productRepository.findProductByProductType(productType);
        if (product == null) {
            throw new Exception("Esse tipo de produto está vinculado a um produto. Não é possível fazer a exclusão!");
        }
        productTypeRepository.delete(productType);
    }

    public List<ProductType> getAllProductTypes() {
        return productTypeRepository.findAll();
    }
}
