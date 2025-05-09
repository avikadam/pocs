package com.example.graphql.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderWithDetails {
    private Order order;
    private CustomerInfo customer;
    private Address shippingAddress;
    private PaymentInfo paymentInfo;
} 