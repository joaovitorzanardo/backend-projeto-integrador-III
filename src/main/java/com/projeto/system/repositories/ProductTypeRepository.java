package com.projeto.system.repositories;

import com.projeto.system.entities.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {

    public ProductType findProductTypeByProductTypeId(Long productTypeId);

}
