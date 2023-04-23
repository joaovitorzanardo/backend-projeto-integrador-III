package com.projeto.system.repositories;

import com.projeto.system.entities.Client;
import com.projeto.system.entities.Product;
import com.projeto.system.entities.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    public Product findProductByProductId(Long productId);
    public Product findProductByProductType(ProductType productType);
    public List<Product> findAllByClient(Client client);

    public Product findProductByClient(Client client);

}
