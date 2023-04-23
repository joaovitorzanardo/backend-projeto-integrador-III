package com.projeto.system.controllers;

import com.projeto.system.dto.ProductTypeDTO;
import com.projeto.system.entities.ProductType;
import com.projeto.system.services.ProductTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "product-type")
public class ProductTypeController {

    @Autowired
    ProductTypeService productTypeService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public String saveProductType(@Valid @RequestBody ProductTypeDTO productTypeDTO) {
        productTypeService.saveProductType(productTypeDTO);
        return "Tipo de Produto Cadastrado com Sucesso!";
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public String updateProductType(@Valid @RequestBody ProductTypeDTO productTypeDTO, @RequestParam Long productTypeId) throws Exception {
        productTypeService.updateProductType(productTypeDTO, productTypeId);
        return "Tipo de Produto Atualizado!";
    }
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public String deleteProductType(@RequestParam Long productTypeId) throws Exception {
        productTypeService.deleteProductType(productTypeId);
        return "Tipo de Produto Excluído!";
    }

    @GetMapping
    public List<ProductType> getAllProductTypes() {
        return productTypeService.getAllProductTypes();
    }


}
