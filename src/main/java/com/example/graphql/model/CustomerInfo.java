package com.example.graphql.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerInfo {
    private String id;
    private String name;
    private String email;
} 