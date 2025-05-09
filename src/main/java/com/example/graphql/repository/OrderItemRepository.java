package com.example.graphql.repository;

import com.example.graphql.model.OrderItem;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface OrderItemRepository extends R2dbcRepository<OrderItem, Long> {
    @Query("SELECT * FROM order_item WHERE order_id = :orderId")
    Flux<OrderItem> findByOrderId(Long orderId);
} 