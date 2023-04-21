package com.projeto.system.services.productType;

import com.projeto.system.dto.ProductTypeDTO;
import com.projeto.system.entities.ProductType;
import com.projeto.system.repositories.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeServiceImpl  implements ProductTypeService{

    @Autowired
    ProductTypeRepository productTypeRepository;


    @Override
    public ProductType saveProductType(ProductTypeDTO productTypeDTO) {
        ProductType productType = ProductType.builder()
                .description(productTypeDTO.getDescription())
                .build();
        return productTypeRepository.save(productType);
    }

    @Override
    public List<ProductType> getAllProductTypes() {
        return productTypeRepository.findAll();
    }
}
