package com.example.graphql.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentInfo {
    private String method;
    private String status;
    private String transactionId;
} 