package com.projeto.system.services;

import com.projeto.system.dto.ProductTypeDTO;
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

    public void saveProductType(ProductTypeDTO productTypeDTO) {
        ProductType productType = ProductType.builder()
                .description(productTypeDTO.getDescription())
                .build();
        productTypeRepository.save(productType);
    }

    public void updateProductType(ProductTypeDTO productTypeDTO, Long productTypeId) {
        ProductType productType = productTypeRepository.findProductTypeByProductTypeId(productTypeId);
        productType.setDescription(productTypeDTO.getDescription());
        productTypeRepository.save(productType);
    }

    public void deleteProductType(Long productTypeId) throws Exception {
        ProductType productType = productTypeRepository.findProductTypeByProductTypeId(productTypeId);
        productTypeRepository.delete(productType);
    }

    public List<ProductType> getAllProductTypes() {
        return productTypeRepository.findAll();
    }

    public ProductType getProductTypeById(Long productTypeId) {
        return productTypeRepository.findProductTypeByProductTypeId(productTypeId);
    }

}
