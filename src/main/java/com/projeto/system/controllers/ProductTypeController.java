package com.projeto.system.controllers;

import com.projeto.system.dto.ProductTypeDTO;
import com.projeto.system.entities.ProductType;
import com.projeto.system.services.productType.ProductTypeService;
import com.projeto.system.services.productType.ProductTypeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "product-type")
public class ProductTypeController {

    @Autowired
    ProductTypeServiceImpl productTypeService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ProductType> saveProductType(@Valid @RequestBody ProductTypeDTO productTypeDTO) {
        ProductType newProductType = productTypeService.saveProductType(productTypeDTO);
        return new ResponseEntity<>(newProductType, HttpStatus.CREATED);
    }

    @GetMapping
    public List<ProductType> getAllProductTypes() {
        return productTypeService.getAllProductTypes();
    }


}
