package com.example.springmvcapp.repositories;

import com.example.springmvcapp.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
    Product findByProdName(final String prodName);
    
}
