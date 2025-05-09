package com.example.graphql.resolver;

import com.example.graphql.model.*;
import com.example.graphql.repository.OrderRepository;
import com.example.graphql.repository.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class OrderResolver {
    
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    
    @QueryMapping("order")
    public Mono<Order> order(@Argument("id") Long id) {
        return orderRepository.findById(id);
    }
    
    @QueryMapping
    public Flux<Order> orders(@Argument("customerId") String customerId) {
        return orderRepository.findByCustomerId(customerId);
    }
    
    @QueryMapping
    public Mono<OrderWithDetails> orderWithDetails(@Argument("id") Long id) {
        return orderRepository.findById(id)
            .flatMap(order -> 
                orderItemRepository.findByOrderId(order.getId())
                    .collectList()
                    .map(orderItems -> {
                        // In a real application, these would be calls to other microservices
                        return OrderWithDetails.builder()
                            .order(order)
                            .customer(CustomerInfo.builder()
                                .id(order.getCustomerId())
                                .name("John Doe") // Mock data
                                .email("john@example.com")
                                .build())
                            .shippingAddress(Address.builder()
                                .street("123 Main St")
                                .city("New York")
                                .state("NY")
                                .zipCode("10001")
                                .build())
                            .paymentInfo(PaymentInfo.builder()
                                .method("CREDIT_CARD")
                                .status("PAID")
                                .transactionId("TXN123")
                                .build())
                            .build();
                    })
            );
    }
    
    @MutationMapping
    public Mono<Order> updateOrderStatus(@Argument("id") Long id, @Argument("status") String status) {
        return orderRepository.findById(id)
            .flatMap(order -> {
                order.setStatus(status);
                return orderRepository.save(order);
            });
    }
} 