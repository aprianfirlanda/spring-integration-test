package com.aprianfirlanda.repositories;

import com.aprianfirlanda.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    @Query("select count(p) from Product p where p.productType.name = ?1")
    long countByProductType(String name);
}