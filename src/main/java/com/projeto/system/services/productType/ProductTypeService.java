package com.projeto.system.services.productType;

import com.projeto.system.dto.ProductTypeDTO;
import com.projeto.system.entities.ProductType;

import java.util.List;

public interface ProductTypeService {

    public ProductType saveProductType(ProductTypeDTO productTypeDTO);
    public List<ProductType> getAllProductTypes();

}
