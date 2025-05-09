package com.example.graphql.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Table("orders")
public class Order {
    @Id
    private Long id;
    
    private String customerId;
    private LocalDateTime orderDate;
    private String status;
    private Double totalAmount;
} 