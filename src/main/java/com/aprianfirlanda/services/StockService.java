package com.aprianfirlanda.services;

import com.aprianfirlanda.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    private final ProductRepository productRepository;

    public StockService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public long getQuantityByProductType(String name) {
        return productRepository.countByProductType(name);
    }
}
