package com.example.graphql.repository;

import com.example.graphql.model.Product;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductRepository extends R2dbcRepository<Product, Long> {
    @Query("SELECT * FROM product WHERE category = :category")
    Flux<Product> findByCategory(String category);
} 