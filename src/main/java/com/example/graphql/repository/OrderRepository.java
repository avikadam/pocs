package com.example.graphql.repository;

import com.example.graphql.model.Order;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderRepository extends R2dbcRepository<Order, Long> {
    @Query("SELECT * FROM orders WHERE customer_id = :customerId")
    Flux<Order> findByCustomerId(String customerId);
} 