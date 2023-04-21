package com.projeto.system.services;

import com.projeto.system.dto.ProductTypeDTO;
import com.projeto.system.entities.ProductType;
import com.projeto.system.repositories.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService {

    @Autowired
    ProductTypeRepository productTypeRepository;

    public ProductType saveProductType(ProductTypeDTO productTypeDTO) {
        ProductType productType = ProductType.builder()
                .description(productTypeDTO.getDescription())
                .build();
        return productTypeRepository.save(productType);
    }

    public List<ProductType> getAllProductTypes() {
        return productTypeRepository.findAll();
    }
}
